package com.example.taller.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.taller.R;

import java.util.List;

public class EntradaAdapter extends RecyclerView.Adapter<EntradaAdapter.ViewHolder> {
    @NonNull
    private List<Tarjetas> list;

    public void Adapter(List<Tarjetas> list){
        this.list=list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView concepto, categoria, fecha, cantidad;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            concepto=(TextView)itemView.findViewById(R.id.concepto_tarj);
            categoria=(TextView)itemView.findViewById(R.id.cat_tarj);
            fecha=(TextView)itemView.findViewById(R.id.fecha_tarj);
            cantidad=(TextView)itemView.findViewById(R.id.cant_tarj);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.tarjeta,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.concepto.setText(list.get(position).getConcepto());
        holder.categoria.setText(list.get(position).getCategoria());
        holder.fecha.setText(list.get(position).getFecha());
        holder.tipo.setText(list.get(position).getTipo());
        holder.favorito.setText(list.get(position).getFavorito());
        holder.cantidad.setText(list.get(position).getCantidad());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
