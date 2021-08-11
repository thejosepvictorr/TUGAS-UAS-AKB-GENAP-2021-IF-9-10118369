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

import java.util.ArrayList;

public class Wisata3Adapter extends RecyclerView.Adapter<Wisata3Adapter.ViewHolder> {
    // 11 Agustus 20201 - 10118369 - Josep Victor Rajaodli - IF 9
    private Context context;
    private ArrayList<Wisata3> wisata3s;

    private DatabaseReference ref;

    public Wisata3Adapter(Context context, ArrayList<Wisata3> wisata3s){
        this.context= context;
        this.wisata3s = wisata3s;
        ref = FirebaseDatabase.getInstance("https://world-of-bandung-default-rtdb.asia-southeast1.firebasedatabase.app")
                .getReference().child("kabupaten_bandung_barat");
    }
    @Override
    public Wisata3Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_wisata3, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Wisata3Adapter.ViewHolder holder, int position) {
        holder.tvPreviewwisata3.setText(wisata3s.get(position).getNama_tempat());
        Glide.with(context)
                .load(wisata3s.get(position).getGambar_tempat())
                .into(holder.ivPreviewwisata3);
    }

    @Override
    public int getItemCount() {
        return wisata3s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPreviewwisata3;
        TextView tvPreviewwisata3;

        public ViewHolder(View itemView) {
            super(itemView);
            ivPreviewwisata3 = itemView.findViewById(R.id.ivPreviewWisata3);
            tvPreviewwisata3 = itemView.findViewById(R.id.tvPreviewWisata3);
        }
    }
}
