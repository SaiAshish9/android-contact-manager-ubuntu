package com.example.contactmanager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private static final String PREFS_NAME = "myPrefsFile";
    private Button saveBtn;
    private TextView result;
    private EditText enterMsg;
    private SharedPreferences myPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterMsg = (EditText) findViewById(R.id.name);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        result = (TextView) findViewById(R.id.result);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPrefs = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myPrefs
                        .edit();
                editor.putString("message",enterMsg.getText().toString());
                editor.commit();
                result.setText("Msg :"+enterMsg.getText().toString());
            }
        });

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);
        if(prefs.contains("message")){
            String msg = prefs.getString("message","not found");
            result.setText("Msg :"+msg);
        }


    }


}