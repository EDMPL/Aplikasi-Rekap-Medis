package com.example.akaed.aplikasipuskesmas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.akaed.aplikasipuskesmas.R;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    Button loginBtn;
    Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.login);
        registerButton = (Button) findViewById(R.id.register);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = null;
                String pass = null;
                user = username.getText().toString();
                pass = password.getText().toString();
                if( user.equals("admin") && pass.equals("admin") ){
                    Intent mainIntent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
                else{
                    Toast.makeText(view.getContext(), "Username atau password salah !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
