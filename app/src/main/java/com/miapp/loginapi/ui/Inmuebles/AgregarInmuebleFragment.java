package com.miapp.loginapi.ui.Inmuebles;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.miapp.loginapi.databinding.FragmentAgregarInmuebleBinding;
import com.miapp.loginapi.request.Inmueble;

import java.io.IOException;
import java.math.BigDecimal;


public class AgregarInmuebleFragment extends Fragment {
    private AgregarInmuebleViewModel mv;
    private FragmentAgregarInmuebleBinding binding;
    private Intent intent;

    private ActivityResultLauncher<Intent> arl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAgregarInmuebleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mv = new ViewModelProvider(this).get(AgregarInmuebleViewModel.class);

        abrirGaleria();

        mv.getUriMutable().observe(getViewLifecycleOwner(), new Observer<Uri>() {
            @Override
            public void onChanged(Uri uri) {
                binding.fotospinner.setImageURI(uri);
                try {
                    mv.getBytesFromUri(requireContext().getContentResolver(), uri);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        binding.btcargarfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arl.launch(intent);
            }
        });
        binding.btguardarinmueble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String direccion = binding.etdireccion.getText().toString();

                String cantidad = binding.etambientes.getText().toString();
                int cantidadentero = Integer.parseInt(cantidad);
                String precioString = binding.etprecio.getText().toString();
                double precioDouble = Double.parseDouble(precioString);
                BigDecimal precio = BigDecimal.valueOf(precioDouble);
                boolean disponible = binding.checkBox.isChecked();
                String Uso = (String) binding.spinnerUso.getSelectedItem();
                String Tipo = (String) binding.spinnerTipo.getSelectedItem();




                Inmueble inmueble=new Inmueble(direccion,Tipo,cantidadentero,disponible,precio,Uso);

                // Cargar el inmueble
                mv.cargarinmueble(inmueble);
            }
        });

    }

    private void abrirGaleria() {
        intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        arl = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                mv.recibirFoto(result);
                Log.d("caca",result.toString());
            }

        });
    }
}