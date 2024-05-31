package com.miapp.loginapi.ui.Contrato;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miapp.loginapi.request.Apicliente;
import com.miapp.loginapi.request.Contrato;
import com.miapp.loginapi.request.Inmueble;
import com.miapp.loginapi.request.Propietario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerContratoViewModel extends AndroidViewModel {
    private static int id;

    private MutableLiveData<Inmueble> inmuebleM;
    private MutableLiveData<Contrato> contratoM;

    private int i;

    public VerContratoViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<Inmueble> getInmueble() {

        if (inmuebleM == null) {
            inmuebleM = new MutableLiveData<>();
        }
        return inmuebleM;
    }

    public LiveData<Contrato> getContratoM() {

        if (contratoM == null) {
            contratoM = new MutableLiveData<>();
        }
        return contratoM;
    }


    public void recuperarInmueble(Bundle bundle) {
        Inmueble inmueble = (Inmueble) bundle.get("inmueble");
        if (inmueble != null) {

            id = inmueble.getId();


        }
        Log.d("primero", "2");

    }

    public void llenarContrato() {
        Apicliente.init(getApplication());
        Apicliente.MisEndPoints api = Apicliente.getEndPoints();
        String token = Apicliente.getToken();
        Log.d("salidasa",token);
        Log.d("salidasa",id+"");

        if (token != null && !token.isEmpty()) {
            Call<Contrato> call = api.obtenerContratosPorInmueble(token, id);
            call.enqueue(new Callback<Contrato>() {
                @Override
                public void onResponse(Call<Contrato> call, Response<Contrato> response) {
                    if (response.isSuccessful()) {
                        contratoM.postValue(response.body());

                        Log.d("salidassss", contratoM.toString());
                        Toast.makeText(getApplication(), "Contrato cargado correctamente", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.d("salida", "estas aca");
                        Toast.makeText(getApplication(), "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Contrato> call, Throwable throwable) {
                    Toast.makeText(getApplication(), "Error en la solicitud", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(getApplication(), "Token no válido", Toast.LENGTH_SHORT).show();
        }
    }
}
    // TODO: Implement the ViewModel
