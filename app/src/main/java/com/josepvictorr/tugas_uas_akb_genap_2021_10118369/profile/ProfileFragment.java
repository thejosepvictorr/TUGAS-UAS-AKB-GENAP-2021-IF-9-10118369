package com.josepvictorr.tugas_uas_akb_genap_2021_10118369.profile;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.R;

public class ProfileFragment extends Fragment {
    // 10 Agustus 2021 - 10118369 - Josep Victor Rajadoli - IF 9
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            ,Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_profile, container, false);

        ImageView ivProfileFoto = rootView.findViewById(R.id.ivFotoProfile);
        Glide.with(this)
                .load(R.drawable.profile)
                .into(ivProfileFoto);
        return rootView;
    }
}