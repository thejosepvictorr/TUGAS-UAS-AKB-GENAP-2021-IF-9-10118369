package com.josepvictorr.tugas_uas_akb_genap_2021_10118369.wisata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.R;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.adapter.Wisata1Adapter;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.model.Wisata1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WisataFragment1 extends Fragment {
    // 11 Agustus 20201 - 10118369 - Josep Victor Rajaodli - IF 9
    private DatabaseReference reference;
    ArrayList<Wisata1> wisata1List;
    Wisata1Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_wisata1, container, false);

        mRecyclerView = rootView.findViewById(R.id.list_kota_bandung);
        mRecyclerView.setHasFixedSize(true);

        mManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mManager);

        reference = FirebaseDatabase.getInstance("https://world-of-bandung-default-rtdb.asia-southeast1.firebasedatabase.app")
                .getReference().child("kota_bandung");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                wisata1List = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Wisata1 wisata1 = dataSnapshot.getValue(Wisata1.class);
                    wisata1.setKey(dataSnapshot.getKey());
                    wisata1List.add(wisata1);
                }
                mAdapter = new Wisata1Adapter(getContext(), wisata1List);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(getContext(), "Terjadi kesalahan", Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}