package com.example.concertonline.ui.watch.fr_watch;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.concertonline.R;
import com.example.concertonline.ui.detail_watch.DetailWatchActivity;

public class FrWatchFragment extends Fragment {

    private FrWatchViewModel mViewModel;

    public static FrWatchFragment newInstance() {
        return new FrWatchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fr_watch_fragment, container, false);
        Button btnTonton = v.findViewById(R.id.btnTonton);
        btnTonton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DetailWatchActivity.class));
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FrWatchViewModel.class);
        // TODO: Use the ViewModel
    }




}
