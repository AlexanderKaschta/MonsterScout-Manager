package de.codeoverflow.frc.monsterscoutmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.codeoverflow.frc.monsterscoutmanager.networking.API;
import de.codeoverflow.frc.monsterscoutmanager.networking.TBAApi;
import de.codeoverflow.frc.monsterscoutmanager.storage.adapter.SimpleEventAdapter;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.SimpleEvent;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ProgressBar bar = findViewById(R.id.progressBar);

        //final FastScrollRecyclerView recyclerView = findViewById(R.id.recycler);
        final FastScrollRecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        TBAApi api = API.getInstance();

        Call<List<SimpleEvent>> listCall = api.getSimpleEvents(2018);

        listCall.enqueue(new Callback<List<SimpleEvent>>() {
            @Override
            public void onResponse(Call<List<SimpleEvent>> call, Response<List<SimpleEvent>> response) {

                List<SimpleEvent> events = response.body();

                Collections.sort(events, new Comparator<SimpleEvent>() {
                    @Override
                    public int compare(SimpleEvent simpleEvent, SimpleEvent t1) {
                        return simpleEvent.getName().compareTo(t1.getName());
                    }
                });

                recyclerView.setAdapter(new SimpleEventAdapter(events));

                bar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                for (SimpleEvent e : response.body()){
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


        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.list_divider));
        recyclerView.addItemDecoration(itemDecoration);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:

                //Finish this task

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
