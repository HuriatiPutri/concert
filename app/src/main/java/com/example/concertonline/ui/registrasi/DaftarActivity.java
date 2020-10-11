package com.example.concertonline.ui.registrasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.concertonline.R;

public class DaftarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
    }

    public void next(View view) {
        startActivity(new Intent(this, InputDataActivity.class));
    }

    public void back(View view) {
        finish();
    }
}
