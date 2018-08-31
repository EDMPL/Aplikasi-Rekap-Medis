package com.example.akaed.aplikasipuskesmas.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.akaed.aplikasipuskesmas.R;
import com.example.akaed.aplikasipuskesmas.activity.IndividualDataActivity;

import java.util.ArrayList;

/**
 * Created by USER on 8/30/2018.
 */

public class FamilyDataAdapter extends BaseAdapter{
    private Context context;
    private final ArrayList<String> textViewValues;

    public FamilyDataAdapter(Context context, ArrayList<String> textViewValues) {
        this.context = context;
        this.textViewValues = textViewValues;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.item, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.textDiagnosaAnak);
            textView.setText(textViewValues.get(position));
        } else {
            gridView = (View) convertView;
        }

        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIndividual =  new Intent(context, IndividualDataActivity.class);
                context.startActivity(intentIndividual);
            }
        });

        return gridView;
    }

    @Override
    public int getCount() {
        return textViewValues.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
