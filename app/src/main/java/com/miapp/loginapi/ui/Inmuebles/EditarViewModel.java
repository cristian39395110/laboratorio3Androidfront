package com.miapp.loginapi.ui.Inmuebles;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miapp.loginapi.request.Apicliente;
import com.miapp.loginapi.request.Inmueble;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditarViewModel extends AndroidViewModel {
   private MutableLiveData<Inmueble> inmuebleM;

    public EditarViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Inmueble> getInmuebleM() {
        if(inmuebleM==null){

            inmuebleM=new MutableLiveData<>();
        }
        return inmuebleM;
    }

    public void setInmuebleM(MutableLiveData<Inmueble> inmuebleM) {
        this.inmuebleM = inmuebleM;
    }

    public void recuperarInmueble(Bundle bundle) {
        Inmueble inmueble = (Inmueble) bundle.get("inmueble");

        if (inmueble != null) {

           inmuebleM.setValue(inmueble);


        }

    }
    public void actualizarInmuebles(Inmueble inmueble) {
        Apicliente.init(getApplication());
        Apicliente.MisEndPoints api = Apicliente.getEndPoints();
        String token = Apicliente.getToken();
        Call<Inmueble> call = api.ActualizarInmueble(token, inmueble);
        call.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if (response.isSuccessful()) {


                    Toast.makeText(getApplication(), "Perfecto", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplication(), "No se Pudo Acceder a los inmuebles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable throwable) {

                Toast.makeText(getApplication(), "No se Pudo Acceder al servidor", Toast.LENGTH_SHORT).show();

            }
        });
    }
    }