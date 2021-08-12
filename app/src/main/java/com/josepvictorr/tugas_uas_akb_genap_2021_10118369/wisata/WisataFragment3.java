package com.josepvictorr.tugas_uas_akb_genap_2021_10118369.wisata;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.R;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.adapter.Wisata2Adapter;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.adapter.Wisata3Adapter;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.model.Wisata2;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.model.Wisata3;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WisataFragment3 extends Fragment {
    // 11 Agustus 2021 - 10118369 - Josep Victor Rajadoli - IF 9
    private DatabaseReference reference;
    ArrayList<Wisata3> wisata3List;
    Wisata3Adapter mAdapter;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_wisata3, container, false);

        mRecyclerView = rootView.findViewById(R.id.list_kabupaten_bandung_barat);
        mRecyclerView.setHasFixedSize(true);

        mManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mManager);

        reference = FirebaseDatabase.getInstance("https://world-of-bandung-default-rtdb.asia-southeast1.firebasedatabase.app")
                .getReference().child("kabupaten_bandung_barat");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                wisata3List = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Wisata3 wisata3 = dataSnapshot.getValue(Wisata3.class);
                    wisata3.setKey(dataSnapshot.getKey());
                    wisata3List.add(wisata3);
                }
                mAdapter = new Wisata3Adapter(getContext(), wisata3List);
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