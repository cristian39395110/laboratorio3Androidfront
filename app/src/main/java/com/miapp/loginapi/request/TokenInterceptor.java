package com.miapp.loginapi.request;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        // Obtener el token de SharedPreferences
        String token = Apicliente.getToken();

        // Si no hay token, proceder sin agregar encabezado
        if (token == null) {
            return chain.proceed(original);
        }

        // Crear una nueva solicitud con el token en el encabezado
        Request.Builder requestBuilder = original.newBuilder()
                .header("Authorization", "Bearer " + token);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
