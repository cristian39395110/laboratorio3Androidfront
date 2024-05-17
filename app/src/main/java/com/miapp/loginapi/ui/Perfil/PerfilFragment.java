package com.miapp.loginapi.ui.Perfil;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.miapp.loginapi.databinding.FragmentPerfilBinding;
import com.miapp.loginapi.request.Propietario;

public class PerfilFragment extends Fragment {

    private FragmentPerfilBinding binding;
    private PerfilViewModel pvm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        pvm = new ViewModelProvider(this).get(PerfilViewModel.class);

        pvm.getMpropietario().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                if (propietario != null) {
                    binding.etcodigo.setText(propietario.getId()+" ");
                    binding.etnombre.setText(propietario.getNombre());
                    binding.etapellido.setText(propietario.getApellido());
                    binding.etdocumento.setText(propietario.getDNI());
                    binding.etpassword.setText("");
                    binding.editTextTextEmailAddress.setText(propietario.getEmail().toString());
                    binding.editTextPhone.setText(propietario.getTelefono());
                    binding.etdomicilio.setText(propietario.getDomicilio().toString());
                } else {
                    Toast.makeText(getContext(), "Propietario no encontrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.bteditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Propietario p=new Propietario(binding.etcodigo.getId(),binding.etnombre.getText().toString(),binding.etapellido.getText().toString(),
                       binding.etdocumento.getText().toString(),binding.etpassword.getText().toString(),binding.editTextPhone.getText().toString(),
                       binding.editTextTextEmailAddress.getText().toString(),binding.etdomicilio.getText().toString());


               pvm.editarPerfil(p);


            }
        });

        pvm.llenarPerfil();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
