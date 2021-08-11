package com.josepvictorr.tugas_uas_akb_genap_2021_10118369.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.R;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.model.Wisata3;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.model.Wisata4;

import java.util.ArrayList;

public class Wisata4Adapter extends RecyclerView.Adapter<Wisata4Adapter.ViewHolder> {
    // 11 Agustus 20201 - 10118369 - Josep Victor Rajaodli - IF 9
    private Context context;
    private ArrayList<Wisata4> wisata4s;

    private DatabaseReference ref;

    public Wisata4Adapter(Context context, ArrayList<Wisata4> wisata4s){
        this.context= context;
        this.wisata4s = wisata4s;
        ref = FirebaseDatabase.getInstance("https://world-of-bandung-default-rtdb.asia-southeast1.firebasedatabase.app")
                .getReference().child("kota_cimahi");
    }
    @Override
    public Wisata4Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_wisata4, parent, false);
        return new Wisata4Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Wisata4Adapter.ViewHolder holder, int position) {
        holder.tvPreviewwisata4.setText(wisata4s.get(position).getNama_tempat());
        Glide.with(context)
                .load(wisata4s.get(position).getGambar_tempat())
                .into(holder.ivPreviewwisata4);
    }

    @Override
    public int getItemCount() {
        return wisata4s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPreviewwisata4;
        TextView tvPreviewwisata4;

        public ViewHolder(View itemView) {
            super(itemView);
            ivPreviewwisata4 = itemView.findViewById(R.id.ivPreviewWisata4);
            tvPreviewwisata4 = itemView.findViewById(R.id.tvPreviewWisata4);
        }
    }
}