package com.miapp.loginapi.ui.Inmuebles;
import static android.app.Activity.RESULT_OK;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.google.gson.Gson;
import com.miapp.loginapi.request.Apicliente;
import com.miapp.loginapi.request.Inmueble;
import com.miapp.loginapi.request.Propietario;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgregarInmuebleViewModel extends AndroidViewModel {
    private MutableLiveData<Uri> uriMutableLiveData;
    private MutableLiveData<Inmueble> mInmueble;

    private static Inmueble inmueblerelleno;


    public AgregarInmuebleViewModel(@NonNull Application application) {
        super(application);
        BigDecimal firstValue = new BigDecimal(3445.544445);
        inmueblerelleno=new Inmueble(null,"barrio 1 de mayo","casa",3,false,false,firstValue,"Comercial");
    }

    public LiveData<Uri> getUriMutable() {

        if (uriMutableLiveData == null) {
            uriMutableLiveData = new MutableLiveData<>();
        }
        return uriMutableLiveData;
    }
    public LiveData<Inmueble> getmInmueble() {
        if (mInmueble == null) {
            mInmueble = new MutableLiveData<>();
        }
        return mInmueble;
    }
    public void getBytesFromUri(ContentResolver contentResolver, Uri uri) throws IOException {
        InputStream inputStream = contentResolver.openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        inmueblerelleno.setPumba(byteArrayOutputStream.toByteArray());
    }


    public void cargarinmueble(Inmueble inmueble) {
        //inmueblerelleno.setDireccion(direccion);
        byte[] by=inmueblerelleno.getPumba();
        inmueblerelleno.setPumba(null);

        // Convierte el objeto inmueble a JSON
        String inmuebleJson = new Gson().toJson(inmueble);
        Log.d("cala", "Inmueble JSON: " + inmuebleJson);

        // Crea el RequestBody para el JSON del inmueble
        RequestBody inmuebleBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), inmuebleJson);

        // Crear RequestBody para la imagen a partir del byte array
        byte[] imagenBytes = by;

        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpeg"), imagenBytes);
        MultipartBody.Part imagenPart = MultipartBody.Part.createFormData("imagen", "imagen.jpg", requestFile);

        // Inicializa la API cliente
        Apicliente.init(getApplication());
        Apicliente.MisEndPoints api = Apicliente.getEndPoints();
        String token = Apicliente.getToken();

        // Crear la llamada a la API
        Call<Inmueble> call = api.CargarInmueble(token, imagenPart, inmuebleBody);
        call.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if (response.isSuccessful()) {
                    Log.d("carajo", "Inmueble enviado exitosamente");
                    Toast.makeText(getApplication(), "Inmueble Creado Correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("carajo", "Error: " + response.message());
                    Toast.makeText(getApplication(), "No se pudo actualizar el Inmueble", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Log.d("carajo", "Fallo: " + t.getMessage());
            }
        });
    }

    public void recibirFoto(ActivityResult result) {
        if (result.getResultCode() == RESULT_OK) {
            Intent data = result.getData();
            Uri uri = data.getData();
            Log.d("salada",uri.toString());
            uriMutableLiveData.setValue(uri);


        }
    }



}