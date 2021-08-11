package com.josepvictorr.tugas_uas_akb_genap_2021_10118369.info;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.R;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.HomeActivity;


public class InfoFragmentSlide3 extends Fragment {
    // 9 Agustus 20201 - 10118369 - Josep Victor Rajaodli - IF 9
    Button btnGetStarted;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            ,Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_info_slide3, container, false);

        btnGetStarted = rootView.findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), HomeActivity.class));

        });
        return rootView;
    }
}