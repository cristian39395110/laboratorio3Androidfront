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
import com.miapp.loginapi.request.Inmueble;

import java.util.List;

public  class InmuebleAdapter extends RecyclerView.Adapter{
    private List<Inmueble> listaInmueble;
    private Context context;
    private LayoutInflater li;
    public InmuebleAdapter(List<Inmueble> listaInmueble, Context context, LayoutInflater li) {
        this.listaInmueble = listaInmueble;
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=li.inflate(R.layout.item,parent,false);
        return new ViewHolderInmueble(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Inmueble inmueble = listaInmueble.get(position);
        ViewHolderInmueble viewHolderinmueble = (ViewHolderInmueble) holder;
        viewHolderinmueble.direccion.setText(inmueble.getDireccion());
        viewHolderinmueble.precio.setText(inmueble.getPrecioBase()+"");
        Glide.with(context)
                .load(URL + inmueble.getFotobase()) // Suponiendo que 'imagen' es la URL relativa de la imagen
                .placeholder(null) // Imagen de reemplazo mientras se carga
                .error("null") // Imagen en caso de error
                .into(viewHolderinmueble.foto);

        ((ViewHolderInmueble) holder).cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle=new Bundle();
                bundle.putSerializable("inmueble",inmueble);
                Navigation.findNavController((Activity) v.getContext(), R.id.nav_host_fragment_content_main).navigate(R.id.nav_inmuebles,bundle);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listaInmueble.size();
    }
    public class ViewHolderInmueble extends RecyclerView.ViewHolder{
        public TextView direccion;
        public TextView precio;
        public ImageView foto;


        public CardView cardView;


        public ViewHolderInmueble(@NonNull View itemView) {
            super(itemView);
            direccion=itemView.findViewById(R.id.tvdireccion);
            precio=itemView.findViewById(R.id.tvprecio);
            foto=itemView.findViewById(R.id.foto);
            cardView = itemView.findViewById(R.id.carView);



        }
    }
}
