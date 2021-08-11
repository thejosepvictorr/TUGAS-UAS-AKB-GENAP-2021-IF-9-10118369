package com.josepvictorr.tugas_uas_akb_genap_2021_10118369.info;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.R;

public class InfoFragmentSlide2 extends Fragment {
    // 9 Agustus 20201 - 10118369 - Josep Victor Rajaodli - IF 9
    ImageView ivKotaBandung, ivKabBandung, ivKabBanBar, ivKotaCimahi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            ,Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_info_slide2, container, false);

        ivKotaBandung = rootView.findViewById(R.id.ivKotaBandung);
        ivKabBandung = rootView.findViewById(R.id.ivKabBandung);
        ivKabBanBar = rootView.findViewById(R.id.ivKabBanBar);
        ivKotaCimahi = rootView.findViewById(R.id.ivKotaCimahi);

        Glide.with(this)
                .load(R.drawable.kota_bandung)
                .into((ImageView) ivKotaBandung);

        Glide.with(this)
                .load(R.drawable.kabupaten_bandung)
                .into((ImageView) ivKabBandung);

        Glide.with(this)
                .load(R.drawable.kabupaten_bandung_barat)
                .into((ImageView) ivKabBanBar);

        Glide.with(this)
                .load(R.drawable.kota_cimahi)
                .into((ImageView) ivKotaCimahi);
        return rootView;
    }
}