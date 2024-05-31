package com.miapp.loginapi.ui.Contrato;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miapp.loginapi.R;
import com.miapp.loginapi.databinding.FragmentInmueblesBinding;
import com.miapp.loginapi.request.Inmueble;
import com.miapp.loginapi.request.InmuebleAdapter;
import com.miapp.loginapi.request.InmuebleAdapterContrato;
import com.miapp.loginapi.ui.Inmuebles.InmueblesFragment;
import com.miapp.loginapi.ui.Inmuebles.InmueblesViewModel;

import java.util.List;

public class ContratoFragment extends Fragment {

    private ContratoViewModel mViewModel;

    private FragmentInmueblesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContratoViewModel mViewModel =
                new ViewModelProvider(this).get(ContratoViewModel.class);

        binding = FragmentInmueblesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ContratoFragment.this)
                        .navigate(R.id.action_nav_inmuebles_to_agregarInmuebleFragment);

            }
        });


        mViewModel.getListaMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                InmuebleAdapterContrato adapter = new InmuebleAdapterContrato(inmuebles, requireContext(), getLayoutInflater());
                RecyclerView rc = binding.lista;
                rc.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
                rc.setAdapter(adapter);

            }
        });
        mViewModel.cargarInmuebles();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}