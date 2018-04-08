package de.codeoverflow.frc.monsterscoutmanager.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.codeoverflow.frc.monsterscoutmanager.R;
import de.codeoverflow.frc.monsterscoutmanager.storage.adapter.EventAdapter;
import de.codeoverflow.frc.monsterscoutmanager.storage.database.AppDatabase;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.Event;
import de.codeoverflow.frc.monsterscoutmanager.util.Connectivity;
import de.codeoverflow.frc.monsterscoutmanager.util.ui.OnRecyclerViewItemClickListener;

public class MainActivity extends AppCompatActivity {


    private FastScrollRecyclerView recyclerView;
    private RelativeLayout layout;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recycler);
        layout = findViewById(R.id.container_empty);


        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();


        final List<Event> events = db.getEventDao().getAll();

        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event e, Event t1) {
                return e.getName().compareTo(t1.getName());
            }
        });

        if (events.size() == 0) {
            layout.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
        else {
            layout.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            EventAdapter adapter = new EventAdapter(events, new OnRecyclerViewItemClickListener() {
                @Override
                public void onRecyclerViewItemClicked(int position) {
                    Toast.makeText(getApplicationContext(), "It's ready to go", Toast.LENGTH_SHORT).show();
                    //
                    startActivity(new Intent(getApplicationContext(), OverviewActivity.class));
                }
            });

            recyclerView.setAdapter(adapter);

            DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
            itemDecoration.setDrawable(getResources().getDrawable(R.drawable.list_divider));
            recyclerView.addItemDecoration(itemDecoration);

        }




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Read out of the database and add those items to the recyclerview

                int size = db.getSimpleEventDao().getAll().size();
                Log.d("Database", "Amount of elements: " + String.valueOf(size));
                //If there is a connection, load data from myTBA
                if (Connectivity.isConnected(getApplicationContext()) || size > 0){
                    startActivity(new Intent(getApplicationContext(), AddEventActivity.class));
                }
                else {
                     Snackbar.make(view, "An internet connection is required!", Snackbar.LENGTH_LONG).show();

                }
            }
        });


    }
}
