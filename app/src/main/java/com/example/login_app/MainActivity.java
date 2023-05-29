package com.example.login_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    String[] server = {"VLS-UAT", "test1", "test2"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterServer;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);

        autoCompleteTextView = findViewById(R.id.auto_complete_server);
        adapterServer = new ArrayAdapter<String>(this, R.layout.list_server, server);

        autoCompleteTextView.setAdapter(adapterServer);
        autoCompleteTextView.setSelection(0);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String server = adapterView.getItemAtPosition(i).toString();

                //Toast.makeText(MainActivity.this, "Server: " + server, Toast.LENGTH_SHORT).show();
            }
        });

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //username: admin
        //password: admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    startActivity(new Intent(MainActivity.this, Home.class));
                }else{
                    Toast.makeText(MainActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}