package com.example.map_google_tg;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    View txtLatitud;
    View txtLongitud;
    GoogleMap mMap;
    private GoogleMap nMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.nMap.setOnMapClickListener(this);
        this.nMap.setOnMapLongClickListener((GoogleMap.OnMapLongClickListener) this);


        LatLng Ecuador = new LatLng(-0.6570459, -79.0344389);
        Marker QUEVEDO = googleMap.addMarker(new MarkerOptions().title("QUEVEDO"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Ecuador));


    }

    private void setOnMapLongClickListener(MainActivity mainActivity) {
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtLatitud.setTextDirection(Integer.parseInt("" + latLng.latitude));
        txtLongitud.setTextDirection(Integer.parseInt("" + latLng.longitude));
    }
}
