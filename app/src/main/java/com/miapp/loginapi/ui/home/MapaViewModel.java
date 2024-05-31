package com.miapp.loginapi.ui.home;

import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationRequest;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.maps.model.LatLng;




public class MapaViewModel extends AndroidViewModel {
    private final MutableLiveData<LatLng> mLocation;

    // Definir algunas ubicaciones estáticas
    private static final LatLng LATITUD_PLAZA = new LatLng(-33.30207, -66.33697);


    public MapaViewModel(@NonNull Application application) {
        super(application);
        // Inicializar con una ubicación estática
        mLocation = new MutableLiveData<>(LATITUD_PLAZA);
    }

    public LiveData<LatLng> getMLocation() {


        return mLocation;
    }

    public LatLng getStaticLocation(int index) {


                return LATITUD_PLAZA;
        }


    public void setStaticLocation(LatLng latLng) {
        mLocation.setValue(latLng);
    }
}