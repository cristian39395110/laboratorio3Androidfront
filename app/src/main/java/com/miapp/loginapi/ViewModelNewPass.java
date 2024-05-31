package com.miapp.loginapi;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.miapp.loginapi.request.Apicliente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModelNewPass extends AndroidViewModel {
    public ViewModelNewPass(@NonNull Application application) {
        super(application);
    }

    public void enviarpassword(String password){
        Log.d("hello",password);
        Apicliente.init(getApplication());
        Apicliente.MisEndPoints api = Apicliente.getEndPoints();

        Call<String> call = api.newpassword(password);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){
                    //listaMutableLiveData.postValue(response.body());
                    Toast.makeText(getApplication(), "Perfecto revise su correo", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (getApplication(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplication().startActivity(intent);
                }
                else{

                    Toast.makeText(getApplication(), "el correo no existe", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String>call, Throwable throwable) {

                Toast.makeText(getApplication(), "No se Pudo Acceder al servidor", Toast.LENGTH_SHORT).show();

            }
        });



    }

}
