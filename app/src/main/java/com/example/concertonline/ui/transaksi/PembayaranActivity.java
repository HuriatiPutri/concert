package com.example.concertonline.ui.transaksi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.concertonline.R;

public class PembayaranActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);
    }
    public void proses(View view) {
        startActivity(new Intent(this, PembayaranActivity.class));
    }
}
