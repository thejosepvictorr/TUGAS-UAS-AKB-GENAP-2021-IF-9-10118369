package com.josepvictorr.tugas_uas_akb_genap_2021_10118369.info;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.MainActivity;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.R;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {
    // 9 Agustus 2021 - 10118369 - Josep Victor Rajadoli - IF 9
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        viewPager = root.findViewById(R.id.view_pager_info);
        return root;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        mainActivity = (MainActivity) getActivity();

        List<Fragment> list = new ArrayList<>();
        list.add(new InfoFragmentSlide1());
        list.add(new InfoFragmentSlide2());
        list.add(new InfoFragmentSlide3());

        pagerAdapter = new InfoFragmentSlideAdapter(requireActivity().getSupportFragmentManager(), list);

        viewPager.setAdapter(pagerAdapter);
    }
}