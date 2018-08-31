package com.example.akaed.aplikasipuskesmas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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

        final Spinner diabetesSpinner = findViewById(R.id.spinnerDiabetes);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.diabetes_melitus,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diabetesSpinner.setAdapter(adapter);
        diabetesSpinner.setSelection(0);

        final Spinner hipertensiSpinner = findViewById(R.id.spinnerHipertensi);

        adapter = ArrayAdapter.createFromResource(this, R.array.hipertensi,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hipertensiSpinner.setAdapter(adapter);
        hipertensiSpinner.setSelection(0);

        final Spinner imunisasiSpinner = findViewById(R.id.spinnerImunisasi);

        adapter = ArrayAdapter.createFromResource(this, R.array.imunisasi,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        imunisasiSpinner.setAdapter(adapter);
        imunisasiSpinner.setSelection(0);

        final Spinner tbcSpinner = findViewById(R.id.spinnerTBC);

        adapter = ArrayAdapter.createFromResource(this, R.array.tbc,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tbcSpinner.setAdapter(adapter);
        tbcSpinner.setSelection(0);

        final Spinner kehamilanSpinner = findViewById(R.id.spinnerKehamilan);

        adapter = ArrayAdapter.createFromResource(this, R.array.kehamilan,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kehamilanSpinner.setAdapter(adapter);
        kehamilanSpinner.setSelection(0);
    }
}
