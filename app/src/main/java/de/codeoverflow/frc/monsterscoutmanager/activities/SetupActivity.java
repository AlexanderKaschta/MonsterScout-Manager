package de.codeoverflow.frc.monsterscoutmanager.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.codeoverflow.frc.monsterscoutmanager.R;
import de.codeoverflow.frc.monsterscoutmanager.util.text.GeneralTextWatcher;
import de.codeoverflow.frc.monsterscoutmanager.util.text.TeamTextWatcher;

public class SetupActivity extends AppCompatActivity {

    private TextInputLayout usernameLayout, teamLayout;
    private TextView usernameInput, teamInput;
    private Button button;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        usernameLayout = findViewById(R.id.input_layout_username);
        usernameInput = findViewById(R.id.input_username);

        teamLayout = findViewById(R.id.input_layout_teamnumber);
        teamInput = findViewById(R.id.input_teamnumber);

        button = findViewById(R.id.submit);

        usernameInput.addTextChangedListener(new GeneralTextWatcher(usernameLayout, usernameInput, SetupActivity.this));
        teamInput.addTextChangedListener(new TeamTextWatcher(teamLayout, teamInput, SetupActivity.this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (teamInput.getText().toString().matches("\\d{1,4}") && usernameInput.getText().toString().trim().length() > 0){
                    //Save data

                    Integer team = Integer.valueOf(teamInput.getText().toString());
                    String name = usernameInput.getText().toString();

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putInt("USER_TEAM_PARTICIPATING", team);
                    editor.putString("USER_NAME", name);
                    editor.putBoolean("FIRST_START", false);
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Please correct the errors!", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}
