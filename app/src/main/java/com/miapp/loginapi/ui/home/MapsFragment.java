package com.miapp.loginapi.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.miapp.loginapi.R;
import com.miapp.loginapi.databinding.FragmentMapsBinding;
public class MapsFragment extends Fragment {
    private MapaViewModel mViewModel;
    private FragmentMapsBinding binding;
    private GoogleMap googleMap;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap map) {
            googleMap = map;
            mViewModel.getMLocation().observe(getViewLifecycleOwner(), new Observer<LatLng>() {
                @Override
                public void onChanged(LatLng location) {
                    if (googleMap != null) {
                        googleMap.clear();
                        googleMap.addMarker(new MarkerOptions().position(location).title("Mi Ubicación"));

                        // Agregar marcadores estáticos
                        googleMap.addMarker(new MarkerOptions().position(mViewModel.getStaticLocation(0)).title("Plaza Pringles"));
                        googleMap.addMarker(new MarkerOptions().position(mViewModel.getStaticLocation(1)).title("Autódromo"));
                        googleMap.addMarker(new MarkerOptions().position(mViewModel.getStaticLocation(2)).title("Plaza Independencia"));
                        googleMap.addMarker(new MarkerOptions().position(mViewModel.getStaticLocation(3)).title("Casa de Tucumán"));

                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 13));
                    }
                }
            });
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMapsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(MapaViewModel.class);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}