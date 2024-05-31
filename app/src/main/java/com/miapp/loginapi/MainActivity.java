package com.miapp.loginapi;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.miapp.loginapi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";
    private MainActivityViewModel vm;
    private ActivityMainBinding binding;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private float acelVal;  // Current acceleration value and gravity
    private float acelLast; // Last acceleration value and gravity
    private float shake;    // Acceleration value differ from gravity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        pedirPermisos();
        vm.lecturaSensores();
        vm.getLecturaM().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // Aquí puedes verificar si el valor de s indica que el teléfono se ha agitado.

                    vm.makeCall(MainActivity.this);

            }
        });

        // Sensor manager and accelerometer setup
        binding.btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplication(), MainActivityNewPass.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplication().startActivity(intent);

            }
        });

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.etMail.getText().toString();
                String password = binding.etPass.getText().toString();
                vm.logueo(email, password);

                binding.etMail.setText("");
                binding.etPass.setText("");
            }
        });

    }

    private void pedirPermisos() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
        }
    }





    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "CALL_PHONE permission granted");
            } else {
                Log.d(TAG, "CALL_PHONE permission denied");
            }
        }
    }
}