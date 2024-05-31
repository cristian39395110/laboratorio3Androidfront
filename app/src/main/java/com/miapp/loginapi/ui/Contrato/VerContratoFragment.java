package com.miapp.loginapi.ui.Contrato;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miapp.loginapi.R;
import com.miapp.loginapi.databinding.FragmentVerContratoBinding;
import com.miapp.loginapi.request.Contrato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VerContratoFragment extends Fragment {

    private VerContratoViewModel vm;
    private FragmentVerContratoBinding binding;
    private Contrato contrato;

    public static VerContratoFragment newInstance() {
        return new VerContratoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentVerContratoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        contrato=new Contrato();

        vm = new ViewModelProvider(this).get(VerContratoViewModel.class);

        vm.getContratoM().observe(getViewLifecycleOwner(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contratos) {
                contrato=contratos;
                String nombre=contrato.getInquilino().getApellido().toString()+" "+contrato.getInquilino().getNombre().toString();

                LocalDate fechaInicio = LocalDate.parse(contrato.getFechaInicio(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate fechaFinalizacion = LocalDate.parse(contrato.getFechaFin(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                binding.tvCodigoContrato.setText(contrato.getId() + "");


                binding.tvFechaInicio.setText(fechaInicio + "");
                binding.tvFechaFinalizacion.setText(fechaFinalizacion + "");
                binding.tvMontoAlquiler.setText(String.valueOf(contrato.getPrecioXmes()));
                binding.tvnom.setText(contrato.getInquilino().getApellido().toString());
                binding.tvapellidose.setText(contrato.getInquilino().getNombre().toString());

                binding.tvInmuebleC.setText(contrato.getInmueble().getDireccion());


            }
        });

        binding.btPagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("contrato",contrato);
               // Navigation.findNavController((Activity) v.getContext(), R.id.nav_host_fragment_content_main).navigate(R.id.pagosFragment,bundle);
                Navigation.findNavController(v).navigate(R.id.pagosFragment, bundle);
            }
        });
        vm.recuperarInmueble(getArguments());
   vm.llenarContrato();


      return root;
    }

}

  /*

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VerContratoViewModel.class);

        // TODO: Use the ViewModel
    }

     */
