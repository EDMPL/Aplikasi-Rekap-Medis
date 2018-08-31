package com.example.akaed.aplikasipuskesmas.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.akaed.aplikasipuskesmas.R;
import com.example.akaed.aplikasipuskesmas.activity.FamilyDataActivity;
import com.example.akaed.aplikasipuskesmas.model.Keluarga;

import java.util.ArrayList;

/**
 * Created by USER on 8/29/2018.
 */

public class DashboardAdapter extends ArrayAdapter<Keluarga> {
    private ArrayList<Keluarga> listKeluarga;
    private Context context;

    public DashboardAdapter(@NonNull Context context, int resource, ArrayList<Keluarga> listKeluarga) {
        super(context, resource, listKeluarga);
        this.listKeluarga = listKeluarga;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //mendapatkan layoutinflater
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Mendapatkan listview items
        View listViewItem = inflater.inflate(R.layout.list_item_dashboard, null, true);

        TextView txtName = (TextView) listViewItem.findViewById(R.id.nameDashboard);

        TextView txtAddress = (TextView) listViewItem.findViewById(R.id.addressDashboard);

        txtName.setText(listKeluarga.get(position).getNamaKepalaKeluarga());

        txtAddress.setText(listKeluarga.get(position).getAlamat());

        listViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFamily = new Intent(context, FamilyDataActivity.class);
                context.startActivity(intentFamily);
            }
        });

        return listViewItem;
    }
}
