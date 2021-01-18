package com.example.contactmanager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity2 extends AppCompatActivity {

    private Button saveBtn;
    private EditText enterMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveBtn = (Button) findViewById(R.id.button);
        enterMsg = (EditText) findViewById(R.id.msg);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!enterMsg.getText().toString().equals("")) {
                    String msg = enterMsg.getText().toString();
                    writeToFile(msg);
                }else{

                }
            }
        });

        if(readFromFile() != null){
            enterMsg.setText(readFromFile());
        }


    }

    private void writeToFile(String msg) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(
                    openFileOutput("todolist.txt", Context.MODE_PRIVATE)
            );
            osw.write(msg);
            osw.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile() {
        String res = "";

        try {
            InputStream inputStream = openFileInput("todolist.txt");
            if (inputStream != null) {

                InputStreamReader isr = new InputStreamReader(inputStream);
                BufferedReader bfr = new BufferedReader(isr);
                String temp = "";
                StringBuilder sb = new StringBuilder();
                while ((temp = bfr.readLine()) != null) {
                    sb.append(temp);
                }
                isr.close();
                res = sb.toString();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }


}