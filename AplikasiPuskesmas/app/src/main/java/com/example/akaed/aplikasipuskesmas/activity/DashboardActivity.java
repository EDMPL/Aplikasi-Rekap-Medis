package com.example.akaed.aplikasipuskesmas.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.akaed.aplikasipuskesmas.adapter.DashboardAdapter;
import com.example.akaed.aplikasipuskesmas.R;
import com.example.akaed.aplikasipuskesmas.model.Keluarga;

import java.util.ArrayList;

public class DashboardActivity extends AppBaseActivity implements SearchView.OnQueryTextListener{
    private ListView listView;
    DashboardAdapter adapter;
    ArrayList<Keluarga> listKeluarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

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
