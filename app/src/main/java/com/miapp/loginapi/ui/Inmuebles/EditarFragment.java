package com.miapp.loginapi.ui.Inmuebles;

import static com.miapp.loginapi.request.Apicliente.URL;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.miapp.loginapi.R;
import com.miapp.loginapi.databinding.FragmentEditarBinding;
import com.miapp.loginapi.databinding.FragmentInmueblesBinding;
import com.miapp.loginapi.request.Inmueble;

public class EditarFragment extends Fragment {

    private EditarViewModel mViewModel;
    private FragmentEditarBinding binding;

    private Inmueble inmueble;

    public static EditarFragment newInstance() {
        return new EditarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
    inmueble=new Inmueble();
        EditarViewModel mViewModel =
                new ViewModelProvider(this).get(EditarViewModel.class);

        binding = FragmentEditarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        mViewModel.getInmuebleM().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmuebles) {
                inmueble=inmuebles;
                if (inmueble != null) {
                    Log.d("ambar", inmueble.getDireccion());
                    binding.eteditarcodigo.setText(String.valueOf(inmueble.getId()));
                    binding.edambienteeditar.setText(String.valueOf(inmueble.getCantidadAmbientes()));
                    binding.etPrecioeditar.setText(String.valueOf(inmueble.getPrecioBase()));
                    binding.eteditardireccion.setText(inmueble.getDireccion());
                    binding.eteditarUso.setText(inmueble.getUso());
                    binding.eteditar.setText(inmueble.getInmuebleTipo());
                    binding.radioButtoneditar.setChecked(inmueble.getDisponible());

                    // Cargar la imagen usando Glide
                    Glide.with(getContext())
                            .load(URL + inmueble.getFotobase()) // Suponiendo que URL es la base de la URL de la imagen
                            .placeholder(null) // Reemplaza con tu recurso de imagen de reemplazo
                            .error("null") // Reemplaza con tu recurso de imagen de error
                            .into(binding.fotoeditar);
                }
            }
        });
        binding.buttoneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inmueble.setDisponible(binding.radioButtoneditar.isChecked());
                mViewModel.actualizarInmuebles(inmueble);
            }
        });

        mViewModel.recuperarInmueble(getArguments());
        return root;
    }
}