package com.example.concertonline.ui.akun;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.concertonline.R;
import com.example.concertonline.ui.registrasi.DaftarActivity;

public class AkunFragment extends Fragment {

    private AkunViewModel mViewModel;
    Boolean isLogiin = false;
    public static AkunFragment newInstance() {
        return new AkunFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.akun_fragment, container, false);
        LinearLayout belumLogin = v.findViewById(R.id.belumLogin);
        LinearLayout sudahLogin = v.findViewById(R.id.sudahLogin);

        if(isLogiin){
            belumLogin.setVisibility(View.GONE);
            sudahLogin.setVisibility(View.VISIBLE);
        }else{
            belumLogin.setVisibility(View.VISIBLE);
            sudahLogin.setVisibility(View.GONE);
        }

        Button btnMasuk = v.findViewById(R.id.btnMasuk);
        Button btnDaftar = v.findViewById(R.id.btnDaftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DaftarActivity.class));
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AkunViewModel.class);
        // TODO: Use the ViewModel
    }

}
