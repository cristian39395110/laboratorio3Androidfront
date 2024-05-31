package com.miapp.loginapi;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.miapp.loginapi.request.Apicliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private static final String TAG = "MainActivityViewModel";
    private MutableLiveData<String> lecturaM;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private float acelVal;
    private float acelLast;
    private float shake;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;



    }

    public LiveData<String> getLecturaM() {
        if(lecturaM==null){

            lecturaM=new MutableLiveData<>();
        }
        return lecturaM;
    }

    public void setLecturaM(MutableLiveData<String> lecturaM) {
        this.lecturaM = lecturaM;
    }

    public void lecturaSensores() {
        sensorManager = (SensorManager) getApplication().getSystemService(Context.SENSOR_SERVICE);
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null) {
            sensorManager.registerListener(new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    float x = event.values[0];
                    float y = event.values[1];
                    float z = event.values[2];
                    acelLast = acelVal;
                    acelVal = (float) Math.sqrt((double) (x * x + y * y + z * z));
                    float delta = acelVal - acelLast;
                    shake = shake * 0.9f + delta; // Perform low-cut filter

                    if (shake > 12) {
                        lecturaM.postValue("shake");
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {
                }
            }, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public boolean isShakeDetected(String lectura) {
        return "shake".equals(lectura);
    }

    public void makeCall(Context context) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:123456789")); // Replace with the phone number you want to call
        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(callIntent);
        } else {
            Toast.makeText(context, "Permission to make calls not granted", Toast.LENGTH_SHORT).show();
        }
    }

    public void logueo(String usuario, String clave) {
        Apicliente.init(getApplication());

        Apicliente.MisEndPoints api = Apicliente.getEndPoints();
        Call<String> call = api.login(usuario, clave);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String token = response.body();
                    Apicliente.saveToken(token);
                    Intent intent = new Intent(getApplication(), MainActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplication().startActivity(intent);
                } else {
                    Toast.makeText(getApplication(), "Contraseña o password incorrecto", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("salida", "Error: " + t.getMessage());
            }
        });
    }
}