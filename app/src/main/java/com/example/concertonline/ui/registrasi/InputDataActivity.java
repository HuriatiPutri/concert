package com.example.concertonline.ui.registrasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.concertonline.R;

public class InputDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);
    }

    public void back(View view) {
        finish();
    }

    public void selesai(View view) {

    }
}
