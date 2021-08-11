package com.josepvictorr.tugas_uas_akb_genap_2021_10118369;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.josepvictorr.tugas_uas_akb_genap_2021_10118369.info.InfoFragment;

public class MainActivity extends AppCompatActivity {
    // 8 Agustus 20201 - 10118369 - Josep Victor Rajaodli - IF 9

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        getFragmentPage(new InfoFragment());
    }

    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}