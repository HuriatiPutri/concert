package com.example.concertonline.ui.transaksi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.concertonline.R;

public class BuyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
    }

    public void back(View view) {
        finish();
    }

    public void pembayaran(View view) {
    }
}
