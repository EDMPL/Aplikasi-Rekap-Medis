package com.example.akaed.aplikasipuskesmas.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.akaed.aplikasipuskesmas.R;
import com.example.akaed.aplikasipuskesmas.adapter.FamilyDataAdapter;

import java.util.ArrayList;

public class FamilyDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_data);

        GridView gridView = (GridView) findViewById(R.id.gridViewFamily);
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 14; i++){
            list.add("Anak ke-" + i);
        }
        gridView.setAdapter(new FamilyDataAdapter(this, list));
    }
}
