package com.overlakehome.locals;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.overlakehome.locals.common.Place;
import com.overlakehome.locals.common.Places;

public class HotPlacesActivity extends ListActivity {

    private Place[] places;
    private double lat = 47.59755;
    private double lng = -122.32775;
    private String[] hotplacelist = new String[20];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            places = Places.Foursquare.findNearby(lat, lng, null, 50, 50);
            for (int i = 0; i < 20; i++) {
                hotplacelist[i] = places[i].getName();
                // Address = places[i].getAddress();
                // Distance --
                // double newlat = places[i].getLat();
                //double newlng = places[i].getLng();
                //distance = FindDistance(lat, lng, newlat, newlng);
                //Category --
         
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        setListAdapter(new ArrayAdapter<String>(this, R.layout.hotplacesactivity, hotplacelist));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);

        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}