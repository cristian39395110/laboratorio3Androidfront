package com.miapp.loginapi.ui.Perfil;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miapp.loginapi.request.Apicliente;
import com.miapp.loginapi.request.Propietario;

import java.io.Console;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> mpropietario;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        mpropietario = new MutableLiveData<>(); // Inicialización aquí
    }

    public LiveData<Propietario> getMpropietario() {
        if (mpropietario == null) {
            mpropietario = new MutableLiveData<>();
        }
        return mpropietario;
    }

    public void editarPerfil(Propietario p){
        Apicliente.init(getApplication());
        Apicliente.MisEndPoints api = Apicliente.getEndPoints();
        String token = Apicliente.getToken();
        Call<Propietario> call = api.ActualizarPropietario(token,p);
        call.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if (response.isSuccessful()) {
                    Log.d("carajo","response");
                    mpropietario.postValue(response.body());
                    Toast.makeText(getApplication(), "Usuario Actualizado Correctamente", Toast.LENGTH_SHORT).show();

                }
                else{
                    Log.d("carajo", "Error: " + response.message());
                    Toast.makeText(getApplication(), "No se pudo actualizar el usauurio", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable throwable) {
                Log.d("carajo","response");
                Toast.makeText(getApplication(), "Error en la solicitud", Toast.LENGTH_SHORT).show();
            }
        });



    }
    public void llenarPerfil() {
        Apicliente.init(getApplication());
        Apicliente.MisEndPoints api = Apicliente.getEndPoints();
        String token = Apicliente.getToken();
        Log.d("salidasas", token);
        Call<Propietario> call = api.getPropietario(token);
        call.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if (response.isSuccessful()) {
                    mpropietario.postValue(response.body());
                    Toast.makeText(getApplication(), "Propietario Cargado Correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplication(), "Usuario No encontrado", Toast.LENGTH_SHORT).show();
                    Log.d("salidasas", "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable throwable) {
                Toast.makeText(getApplication(), "Error en la solicitud", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
