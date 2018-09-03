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

public class InputAnggotaActivity extends AppBaseActivity {
    private Button btnSubmitAnggota, btnMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_anggota);

        btnSubmitAnggota = (Button) findViewById(R.id.buttonSubmitAnggota);

        btnSubmitAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNama = (EditText) findViewById(R.id.etNama);

                //Memeriksa apakah field kosong
                if(etNama.getText().toString().equals("")){
                    etNama.setError("Silakan isi data !");
                }
                else{
                    etNama.setError(null);
                    Intent intentInputPenyakit = new Intent(v.getContext(), InputPenyakitActivity.class);
                    startActivity(intentInputPenyakit);
                }
            }
        });

        btnMap = (Button) findViewById(R.id.buttonMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMap = new Intent(v.getContext(), MapsActivity.class);
                startActivity(intentMap);
            }
        });

        final Spinner agamaSpinner = findViewById(R.id.spinnerAgama);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.agama,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        agamaSpinner.setAdapter(adapter);
        agamaSpinner.setSelection(0);

        final Spinner pendidikanSpinner = findViewById(R.id.spinnerPendidikan);

        adapter = ArrayAdapter.createFromResource(this, R.array.pendidikan,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pendidikanSpinner.setAdapter(adapter);
        pendidikanSpinner.setSelection(0);

        final Spinner pekerjaanSpinner = findViewById(R.id.spinnerPekerjaan);

        adapter = ArrayAdapter.createFromResource(this, R.array.pekerjaan,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pekerjaanSpinner.setAdapter(adapter);
        pekerjaanSpinner.setSelection(0);
    }
}
