package com.miapp.loginapi.request;

import static com.miapp.loginapi.request.Apicliente.URL;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.miapp.loginapi.R;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PagoAdapter extends RecyclerView.Adapter<PagoAdapter.PagosViewHolder>{
    private List<Pago> pagos = new ArrayList<>();
    private Context context;

    public PagoAdapter( Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public PagoAdapter.PagosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View root=LayoutInflater.from(parent.getContext()).inflate(R.layout.itempagos,parent,false);
       return new PagoAdapter.PagosViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull PagoAdapter.PagosViewHolder holder, int position) {
        Pago pago = pagos.get(position);
       holder.tvIdPago.setText(String.valueOf(pago.getNumeroPago()));
        holder.tvCodigoContratoPago.setText(String.valueOf(pago.getContratoId()));
        holder.tvMonto.setText(String.valueOf(pago.getImporte()));
        LocalDate fechaInicio = LocalDate.parse(pago.getFechaPago(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String fechaInicioFormateada = fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));


        holder.tvFechaPago.setText(fechaInicioFormateada);

    }

    @Override
    public int getItemCount() {
        return pagos.size();


    }
    public void setPagos(List<Pago> pagos){
        this.pagos = pagos;
        notifyDataSetChanged();
    }



    public static class PagosViewHolder extends RecyclerView.ViewHolder{
        public TextView tvIdPago, tvCodigoContratoPago, tvMonto, tvFechaPago;

        public PagosViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdPago = itemView.findViewById(R.id.etnumeropago);
            tvCodigoContratoPago = itemView.findViewById(R.id.etIdcontrato);
            tvMonto = itemView.findViewById(R.id.etImporte);
            tvFechaPago = itemView.findViewById(R.id.etfechapago);




        }
    }

}