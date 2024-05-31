package com.miapp.loginapi.ui.Contrato;

import android.app.Application;
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

public class ContratoViewModel extends AndroidViewModel {


    private MutableLiveData<List<Inmueble>> listaMutableLiveData;

    public ContratoViewModel(@NonNull Application application) {
        super(application);
    }




    public MutableLiveData<List<Inmueble>> getListaMutableLiveData() {
        if (listaMutableLiveData==null){
            listaMutableLiveData=new MutableLiveData<>();
        }
        return listaMutableLiveData;
    }

    public void setListaMutableLiveData(MutableLiveData<List<Inmueble>> listaMutableLiveData) {
        this.listaMutableLiveData = listaMutableLiveData;
    }

    public void cargarInmuebles(){
        Apicliente.init(getApplication());
        Apicliente.MisEndPoints api = Apicliente.getEndPoints();
        String token = Apicliente.getToken();
        Call<List<Inmueble>> call = api.GetInmueblescontrato(token);
        call.enqueue(new Callback<List<Inmueble>>() {
            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
                if(response.isSuccessful()){

                    listaMutableLiveData.postValue(response.body());
                    Toast.makeText(getApplication(), "Perfecto", Toast.LENGTH_SHORT).show();

                }
                else{

                    Toast.makeText(getApplication(), "No se Pudo Acceder a los inmuebles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable throwable) {

                Toast.makeText(getApplication(), "No se Pudo Acceder al servidor", Toast.LENGTH_SHORT).show();

            }
        });



    }
}