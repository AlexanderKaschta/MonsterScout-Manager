package de.codeoverflow.frc.monsterscoutmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import de.codeoverflow.frc.monsterscoutmanager.util.Connectivity;

public class MainActivity extends AppCompatActivity {

    private boolean isEmpty = true;
    private RecyclerView recyclerView;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layout = findViewById(R.id.container_empty);

        if (isEmpty) {
            layout.setVisibility(View.VISIBLE);
        }

        //Read out of the database and add those items to the recyclerview


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //If there is a connection, load data from myTBA
                if (Connectivity.isConnected(getApplicationContext())){
                    startActivity(new Intent(getApplicationContext(), AddEventActivity.class));
                }
                else {
                     Snackbar.make(view, "An internet connection is required!", Snackbar.LENGTH_LONG).show();

                }



            }
        });


    }
}
