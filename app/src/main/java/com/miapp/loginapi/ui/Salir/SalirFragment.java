package com.miapp.loginapi.ui.Salir;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.miapp.loginapi.R;
import com.miapp.loginapi.databinding.FragmentInmueblesBinding;
import com.miapp.loginapi.databinding.FragmentSalirBinding;
import com.miapp.loginapi.request.Inmueble;
import com.miapp.loginapi.request.InmuebleAdapter;
import com.miapp.loginapi.ui.Inmuebles.InmueblesFragment;
import com.miapp.loginapi.ui.Inmuebles.InmueblesViewModel;

import java.util.List;


public class SalirFragment extends Fragment {

    private FragmentSalirBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogoutConfirmationDialog();
            }
        });

        return view;
    }

    private void showLogoutConfirmationDialog() {
        new AlertDialog.Builder(requireContext())
                .setTitle("Confirmar Cierre de Sesión")
                .setMessage("¿Estás seguro de que deseas cerrar sesión?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Toast.makeText(requireContext(), "Sesión cerrada", Toast.LENGTH_SHORT).show();

                         System.exit(0);
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}