package com.example.parcialn2;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private List<ClipData.Item> itemList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ClipData.Item item);
    }

    public Adaptador(List<ClipData.Item> itemList, OnItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ClipData.Item item = itemList.get(position);
        holder.bind(item, listener);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Define tus vistas aquí

        public ViewHolder(View itemView) {
            super(itemView);
            // Inicializa tus vistas
        }

        public void bind(final ClipData.Item item, final OnItemClickListener listener) {
            // Establece los valores de las vistas y el listener
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }
}


