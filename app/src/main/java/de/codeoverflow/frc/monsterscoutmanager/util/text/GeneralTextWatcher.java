package de.codeoverflow.frc.monsterscoutmanager.util.text;

import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * This is a implementation of a {@link TextWatcher} for a TextInputLayout. It only checks, if there is a
 * input or not.
 * @version 1.0
 * @author Alex
 * Created by Alex on 16.02.2018.
 */

public class GeneralTextWatcher implements TextWatcher {

    private TextView view;
    private TextInputLayout layout;
    private Activity context;

    public GeneralTextWatcher(TextInputLayout layout, TextView view, Activity context){
        this.view = view;
        this.layout = layout;
        this.context = context;
    }

    private void requestFocus(View v){
        if (v.requestFocus()){
            context.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        String input = view.getText().toString();

        if (input.trim().length() == 0){
            layout.setError("Please enter a name!");
            requestFocus(view);
        }
        else {
            layout.setErrorEnabled(false);
        }


    }
}
