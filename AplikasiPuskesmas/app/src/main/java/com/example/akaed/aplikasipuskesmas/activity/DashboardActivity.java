package com.example.akaed.aplikasipuskesmas.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.akaed.aplikasipuskesmas.adapter.DashboardAdapter;
import com.example.akaed.aplikasipuskesmas.R;
import com.example.akaed.aplikasipuskesmas.model.Keluarga;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

public class DashboardActivity extends AppBaseActivity implements SearchView.OnQueryTextListener{
    private ListView listView;
    DashboardAdapter adapter;
    ArrayList<Keluarga> listKeluarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Untuk menghilangkan tombol back pada toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        listKeluarga = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            listKeluarga.add(new Keluarga("Bapak/Ibu " + i, "Jalan alamat no. " + i));
        }
        listView = (ListView) findViewById(R.id.listViewDashboard);
        adapter = new DashboardAdapter(this, R.layout.list_item_dashboard, listKeluarga);
        listView.setAdapter(adapter);

        SearchView searchView = (SearchView) findViewById(R.id.searchView);
        SearchView.SearchAutoComplete searchAutoComplete =
                (SearchView.SearchAutoComplete)searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchAutoComplete.setTextColor(Color.WHITE);
        searchView.setOnQueryTextListener(this);
        searchView.setFocusable(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.buttonInputAnggota);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentInputAnggota = new Intent(v.getContext(), InputAnggotaActivity.class);
                startActivity(intentInputAnggota);
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toUpperCase();
        ArrayList<Keluarga> newList = new ArrayList<>();
        for(Keluarga data : listKeluarga){
            String name = data.getNamaKepalaKeluarga().toUpperCase();
            if (name.contains(newText))
                newList.add(data);
        }
        adapter = new DashboardAdapter(this, R.layout.list_item_dashboard, newList);
        listView.setAdapter(adapter);
        ((DashboardAdapter) listView.getAdapter()).notifyDataSetChanged();
        return true;
    }
}
