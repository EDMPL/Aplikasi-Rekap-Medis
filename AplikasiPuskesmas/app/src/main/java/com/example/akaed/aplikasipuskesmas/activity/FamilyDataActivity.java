package com.example.akaed.aplikasipuskesmas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.example.akaed.aplikasipuskesmas.R;
import com.example.akaed.aplikasipuskesmas.adapter.FamilyDataAdapter;

import java.util.ArrayList;

public class FamilyDataActivity extends AppBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_data);

        GridView gridView = (GridView) findViewById(R.id.gridViewFamily);
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 14; i++){
            list.add("HIV\nDiabetes " + i);
        }
        gridView.setAdapter(new FamilyDataAdapter(this, list));

        TextView textViewAyah =  (TextView) findViewById(R.id.namaAyah);
        textViewAyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIndividual =  new Intent(v.getContext(), IndividualDataActivity.class);
                startActivity(intentIndividual);
            }
        });

        TextView textViewIbu =  (TextView) findViewById(R.id.namaIbu);
        textViewIbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIndividual =  new Intent(v.getContext(), IndividualDataActivity.class);
                startActivity(intentIndividual);
            }
        });
    }
}
