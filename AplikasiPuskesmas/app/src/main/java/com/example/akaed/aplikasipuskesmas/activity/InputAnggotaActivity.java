package com.example.akaed.aplikasipuskesmas.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.akaed.aplikasipuskesmas.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class InputAnggotaActivity extends AppBaseActivity {
    private Button btnSubmitAnggota, btnMap;
    private EditText tglLahir;
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

                    //Untuk menghitung usia dari nik
                    EditText etNIK = (EditText) findViewById(R.id.etNIK);
                    RadioButton jk = (RadioButton) findViewById(R.id.laki);
                    countAgeFromNIK(etNIK.getText().toString(), jk.isChecked());

                    /*//Untuk menghitung usia dari tanggal lahir
                    DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
                    //Mengubah string tanggal yang diambil dari nik menjadi format hh/bb/tttt
                    String strDate = tglLahir.getText().toString();
                    try {
                        Date birthDate = sourceFormat.parse(strDate);
                        countAge(birthDate);
                        if(tglLahir.getError()!= null)
                            return;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if(tglLahir.getError() != null)
                        tglLahir.setError(null);*/

                    if(tglLahir.getError() == null) {
                        Intent intentInputPenyakit = new Intent(v.getContext(), InputPenyakitActivity.class);
                        startActivity(intentInputPenyakit);
                    }
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

        tglLahir = (EditText) findViewById(R.id.etTanggalLahir);
        tglLahir.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //Untuk menghitung usia dari tanggal lahir
                DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
                //Mengubah string tanggal yang diambil dari nik menjadi format hh/bb/tttt
                String strDate = tglLahir.getText().toString();
                try {
                    Date birthDate = sourceFormat.parse(strDate);
                    countAge(birthDate);
                    if(tglLahir.getError()!= null)
                        return;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if(tglLahir.getError() != null)
                    tglLahir.setError(null);
            }
        });
        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String format = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
                tglLahir.setText(sdf.format(myCalendar.getTime()));
            }
        };

        tglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(InputAnggotaActivity.this, date, myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    public void countAgeFromNIK(String nik, boolean isPria) {
        if(nik.length() != 16){
            Toast.makeText(InputAnggotaActivity.this,"NIK TIDAK VALID !", Toast.LENGTH_LONG).show();
        }
        else{
            try{
                //Mengambil 6 digit tanggal lahir dari nik
                String temp = nik.substring(6, 12);
                if(Integer.parseInt(temp.substring(4)) > 18){
                    DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String strDate = null;
                    //Periksa jika jenis kelamin wanita maka tanggal akan dikurangi 40
                    if(isPria){
                        //Mengubah string tanggal yang diambil dari nik menjadi format hh/bb/tttt
                        strDate = temp.substring(0,2) + "/" + temp.substring(2,4) + "/" + "19" + temp.substring(4);
                    }
                    else{
                        //Tanggal dikurangi 40
                        int tgl = Integer.valueOf(temp.substring(0,2)) - 40;
                        //Mengubah string tanggal yang diambil dari nik menjadi format hh/bb/tttt
                        strDate = String.valueOf(tgl) + "/" + temp.substring(2,4) + "/" + "19" + temp.substring(4);
                    }
                    Date date = sourceFormat.parse(strDate);

                    //Mengambil tanggal saat ini
                    Date dateNow = new Date();
                    Calendar calDate = Calendar.getInstance();
                    calDate.setTime(date);
                    Calendar calDateNow = Calendar.getInstance();
                    calDateNow.setTime(dateNow);

                    int diff = calDateNow.get(YEAR) - calDate.get(YEAR);
                    if (calDate.get(MONTH) > calDateNow.get(MONTH) ||
                            (calDate.get(MONTH) == calDateNow.get(MONTH) && calDate.get(DATE) > calDateNow.get(DATE))) {
                        diff--;
                    }
                    Toast.makeText(InputAnggotaActivity.this,"Umur anda: " + diff, Toast.LENGTH_LONG).show();
                    System.out.println("Umur anda: " + diff);
                }
            }catch (Exception e) {
                System.out.println("NIK TIDAK VALID !");
            }
        }
    }

    public void countAge(Date birthDate) {
        //Mengambil tanggal saat ini
        Date dateNow = new Date();
        if(birthDate.after(dateNow)){
            tglLahir.setError("Tanggal lahir tidak valid !");
            return;
        }
        else{
            tglLahir.setError(null);
        }
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(birthDate);
        Calendar calDateNow = Calendar.getInstance();
        calDateNow.setTime(dateNow);

        int diff = calDateNow.get(YEAR) - calDate.get(YEAR);
        if (calDate.get(MONTH) > calDateNow.get(MONTH) ||
                (calDate.get(MONTH) == calDateNow.get(MONTH) && calDate.get(DATE) > calDateNow.get(DATE))) {
            diff--;
        }
        Toast.makeText(InputAnggotaActivity.this,"Umur anda: " + diff, Toast.LENGTH_LONG).show();
        System.out.println("Umur anda: " + diff);
    }
}
