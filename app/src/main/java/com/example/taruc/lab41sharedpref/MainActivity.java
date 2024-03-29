package com.example.taruc.lab41sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewProfile;
    private TextView textViewName;
    private static final String PREF_NAME = "com.example.taruc.lab41sharedpref";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageViewProfile = findViewById(R.id.imageViewProfile);
        textViewName = findViewById(R.id.textViewName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onResume() {
        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        int gender = sharedPreferences.getInt(getString(R.string.gender), -1);
        String name = sharedPreferences.getString(getString(R.string.user_name), getString(R.string.no_name));
        textViewName.setText(name);
        if(gender == 1) {
            imageViewProfile.setImageResource(R.drawable.male);
        } else if(gender == 0) {
            imageViewProfile.setImageResource(R.drawable.female);
        }

        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_settings2) {
            Intent intent = new Intent(this, SettingsActivity2.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
