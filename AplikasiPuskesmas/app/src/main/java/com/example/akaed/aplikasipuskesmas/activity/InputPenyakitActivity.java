package com.example.akaed.aplikasipuskesmas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.akaed.aplikasipuskesmas.R;

public class InputPenyakitActivity extends AppBaseActivity {
    Button btnSubmitPenyakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_penyakit);

        btnSubmitPenyakit = (Button) findViewById(R.id.buttonSubmitPenyakit);
        btnSubmitPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etPenyakit = (EditText) findViewById(R.id.etPnyekitSaatIni);

                if(etPenyakit.getText().toString().equals("")){
                    etPenyakit.setError("Silakan isi data !");
                }
                else{
                    Intent intentDashboard = new Intent(v.getContext(), DashboardActivity.class);
                    startActivity(intentDashboard);
                }
            }
        });
    }
}
