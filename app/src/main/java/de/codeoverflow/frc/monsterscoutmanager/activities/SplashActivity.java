package de.codeoverflow.frc.monsterscoutmanager.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isFirstStart = sharedPref.getBoolean("FIRST_START", true);
        if(isFirstStart){
            startActivity(new Intent(this, SetupActivity.class));
            finish();
        }
        else {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }


    }
}
