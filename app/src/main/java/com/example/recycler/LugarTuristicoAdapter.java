package com.example.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycler.model.LugarTuristico;

import java.util.List;

public class LugarTuristicoAdapter extends RecyclerView.Adapter<LugarTuristicoAdapter.ViewHolder> {

    private List<LugarTuristico> lugaresTuristicos;
    private Context context;

    public LugarTuristicoAdapter(List<LugarTuristico> lugaresTuristicos) {
        this.lugaresTuristicos = lugaresTuristicos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LugarTuristicoAdapter.ViewHolder holder, int position) {
        LugarTuristico lugarTuristico = lugaresTuristicos.get(position);
        holder.nombreTextView.setText(lugarTuristico.getNombre_lugar());
        holder.descripcionTextView.setText(lugarTuristico.getDescripcion());

        Glide.with(context)
                .load("https://uealecpeterson.net/turismo/assets/imgs/logos_gifs/"
                        + lugarTuristico.getLogo())
                .into(holder.logoImageView);
    }

    @Override
    public int getItemCount() {
        Log.d("LugarTuristicoAdapter", "Número de elementos: " + lugaresTuristicos.size());
        return lugaresTuristicos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        TextView descripcionTextView;
        ImageView logoImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            descripcionTextView = itemView.findViewById(R.id.descripcionTextView);
            logoImageView = itemView.findViewById(R.id.logoImageView);
        }
    }
}
