package de.codeoverflow.frc.monsterscoutmanager;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.codeoverflow.frc.monsterscoutmanager.util.text.GeneralTextWatcher;
import de.codeoverflow.frc.monsterscoutmanager.util.text.TeamTextWatcher;

public class SetupActivity extends AppCompatActivity {

    private TextInputLayout usernameLayout, teamLayout;
    private TextView usernameInput, teamInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        usernameLayout = findViewById(R.id.input_layout_username);
        usernameInput = findViewById(R.id.input_username);

        teamLayout = findViewById(R.id.input_layout_teamnumber);
        teamInput = findViewById(R.id.input_teamnumber);

        usernameInput.addTextChangedListener(new GeneralTextWatcher(usernameLayout, usernameInput, SetupActivity.this));
        teamInput.addTextChangedListener(new TeamTextWatcher(teamLayout, teamInput, SetupActivity.this));

    }
}
