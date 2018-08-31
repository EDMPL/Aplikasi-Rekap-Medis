package com.example.akaed.aplikasipuskesmas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.akaed.aplikasipuskesmas.R;

public class InputAnggotaActivity extends AppBaseActivity {
    private Button btnSubmitAnggota;
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
    }
}
