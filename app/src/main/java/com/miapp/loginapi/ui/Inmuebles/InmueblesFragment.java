package com.miapp.loginapi.ui.Inmuebles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.miapp.loginapi.databinding.FragmentInmueblesBinding;
import com.miapp.loginapi.request.Inmueble;
import com.miapp.loginapi.request.InmuebleAdapter;

import java.util.List;


public class InmueblesFragment extends Fragment {
   private InmueblesViewModel inmueblesViewModel;
    private FragmentInmueblesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InmueblesViewModel inmueblesViewModel =
                new ViewModelProvider(this).get(InmueblesViewModel.class);

        binding = FragmentInmueblesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        inmueblesViewModel.getListaMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                InmuebleAdapter adapter = new InmuebleAdapter(inmuebles, requireContext(), getLayoutInflater());
                RecyclerView rc = binding.lista;
                rc.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
                rc.setAdapter(adapter);

            }
        });
        inmueblesViewModel.cargarInmuebles();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}