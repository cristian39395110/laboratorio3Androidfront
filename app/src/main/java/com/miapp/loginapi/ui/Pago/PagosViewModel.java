package com.miapp.loginapi.ui.Pago;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.miapp.loginapi.request.Apicliente;
import com.miapp.loginapi.request.Contrato;
import com.miapp.loginapi.request.Pago;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PagosViewModel extends AndroidViewModel {
    private MutableLiveData<List<Pago>> pagos;
    private int id;

    public PagosViewModel(@NonNull Application application) {
        super(application);
        this.pagos = new MutableLiveData<>();
    }

    public LiveData<List<Pago>> getPagos() {
        return pagos;
    }
    public void recuperarContrato(Bundle bundle){
        Contrato contrato = (Contrato) bundle.get("contrato");
        if(contrato != null){
            id = contrato.getId();
        }
    }

    public void cargarPagos() {
        Apicliente.init(getApplication());
        Apicliente.MisEndPoints api = Apicliente.getEndPoints();
        String token = Apicliente.getToken();
        Log.d("salidasas", token);
        if (token != null && !token.isEmpty()) {
            Call<List<Pago>> call = api.obternerPagos(token, id);
            call.enqueue(new Callback<List<Pago>>() {
                @Override
                public void onResponse(Call<List<Pago>> call, Response<List<Pago>> response) {
                    if (response.isSuccessful()){
                        pagos.setValue(response.body());
                        Log.d("Pagos", "Pagos cargados exitosamente.");
                    }else{
                        Log.d("Pagos", "Error al cargar pagos: " + response.message());
                        Log.d("Pagos", "Response code: " + response.code());
                        Log.d("Pagos", "Response error body: " + response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<List<Pago>> call, Throwable t) {
                    Log.e("InmueblesViewModel", "Error en la llamada: ", t);
                }
            });
        } else{
            Log.d("InmueblesViewModel", "Token no encontrado o vacío");
        }
    }
}