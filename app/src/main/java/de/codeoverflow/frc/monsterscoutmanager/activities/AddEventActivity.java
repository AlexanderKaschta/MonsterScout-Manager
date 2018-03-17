package de.codeoverflow.frc.monsterscoutmanager.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.codeoverflow.frc.monsterscoutmanager.R;
import de.codeoverflow.frc.monsterscoutmanager.networking.API;
import de.codeoverflow.frc.monsterscoutmanager.networking.TBAApi;
import de.codeoverflow.frc.monsterscoutmanager.storage.adapter.SimpleEventAdapter;
import de.codeoverflow.frc.monsterscoutmanager.storage.database.AppDatabase;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.Event;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.SimpleEvent;
import de.codeoverflow.frc.monsterscoutmanager.util.ui.OnRecyclerViewItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEventActivity extends AppCompatActivity {

    private List<SimpleEvent> events;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ProgressBar bar = findViewById(R.id.progressBar);
        final FastScrollRecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        TBAApi api = API.getInstance();

        Call<List<SimpleEvent>> listCall = api.getSimpleEvents(2018);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        events = db.getSimpleEventDao().getAll();

        if (events.size() == 0) {
            listCall.enqueue(new Callback<List<SimpleEvent>>() {
                @Override
                public void onResponse(Call<List<SimpleEvent>> call, Response<List<SimpleEvent>> response) {

                    events = response.body();

                    Collections.sort(events, new Comparator<SimpleEvent>() {
                        @Override
                        public int compare(SimpleEvent simpleEvent, SimpleEvent t1) {
                            return simpleEvent.getName().compareTo(t1.getName());
                        }
                    });

                    SimpleEventAdapter adapter = new SimpleEventAdapter(events, new OnRecyclerViewItemClickListener() {
                        @Override
                        public void onRecyclerViewItemClicked(int position) {
                            Toast.makeText(getApplicationContext(), "Item clicked: " + position, Toast.LENGTH_SHORT).show();
                            addEvent(position);
                        }
                    });


                    recyclerView.setAdapter(adapter);

                    bar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);


                    for (SimpleEvent e : response.body()) {
                        db.getSimpleEventDao().insert(e);
                        System.out.println(e.getName());
                    }
                }

                @Override
                public void onFailure(Call<List<SimpleEvent>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Couldn't fetch data", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            });

        } else {

            recyclerView.setAdapter(new SimpleEventAdapter(events, new OnRecyclerViewItemClickListener() {
                @Override
                public void onRecyclerViewItemClicked(int position) {
                    Toast.makeText(getApplicationContext(), "Item clicked: " + position, Toast.LENGTH_SHORT).show();
                    addEvent(position);
                }
            }));
            bar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.list_divider));
        recyclerView.addItemDecoration(itemDecoration);

    }


    private void addEvent(int index){

        //If there are some events ...
        if (events.size() != 0){

            SimpleEvent simpleEvent = events.get(index);
            System.out.println("Item clicked: " + simpleEvent.getName());

            //Check, if there is already an item in the database

            Event event = new Event(simpleEvent.getKey(), simpleEvent.getEventCode()
                    , simpleEvent.getName(), simpleEvent.getYear(), simpleEvent.getTimezone()
                    , simpleEvent.getCity(), simpleEvent.getCountry(), simpleEvent.getStartDate(), false);

            db.getEventDao().insert(event);
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();



        }


    }

}
