package com.example.concertonline.ui.transaksi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.concertonline.R;

public class KonfirmasiActivity extends AppCompatActivity {

    ImageView imgEvent;
    TextView txtTitle, txtDate, txtTime, txtDesc;
    String img,title,desc,time,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);

        imgEvent = findViewById(R.id.imgEvent);
        txtTitle = findViewById(R.id.txtTitle);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);

        img = getIntent().getStringExtra("img");
        title = getIntent().getStringExtra("title");
        time = getIntent().getStringExtra("time");
        date = getIntent().getStringExtra("date");

        txtTitle.setText(title);
        txtDate.setText(date);
        txtTime.setText(time);

        Glide.with(this)
                .load(img)
                .placeholder(R.drawable.noimg)
                .into(imgEvent);

    }

    public void back(View view) {
        finish();
    }

    public void konfirmasi(View view) {
        finish();
    }
}
