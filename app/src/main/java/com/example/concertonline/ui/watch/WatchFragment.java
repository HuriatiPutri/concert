package com.example.concertonline.ui.watch;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.concertonline.R;
import com.example.concertonline.adapter.PagerAdapter;

public class WatchFragment extends Fragment {

    private WatchViewModel mViewModel;
    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;

    public static WatchFragment newInstance() {
        return new WatchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.watch_fragment, container, false);
//        toolbar = v.findViewById(R.id.toolbar); //Inisialisasi dan Implementasi id Toolbar

        //Menerapkan TabLayout dan ViewPager pada Activity
        tabLayout = v.findViewById(R.id.tab_layout);
        viewPager = v.findViewById(R.id.pager);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WatchViewModel.class);
        // TODO: Use the ViewModel
        PagerAdapter pagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());

        //Memasang Adapter pada ViewPager
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Callback Interface dipanggil saat status pilihan tab berubah.
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Dipanggil ketika tab memasuki state/keadaan yang dipilih.
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //Dipanggil saat tab keluar dari keadaan yang dipilih.
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //Dipanggil ketika tab yang sudah dipilih, dipilih lagi oleh user.
            }
        });
    }

}
