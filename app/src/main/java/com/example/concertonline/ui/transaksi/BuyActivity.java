package com.example.concertonline.ui.transaksi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.concertonline.R;
import com.example.concertonline.model.Popular;

import java.util.ArrayList;
import java.util.List;

public class BuyActivity extends AppCompatActivity {

    ImageView imgEvent;
    TextView txtTitle, txtDate, txtTime, txtDesc;

    private List<Popular> list  = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

//        list = getIntent().getParcelableArrayListExtra("details");
        imgEvent = findViewById(R.id.imgEvent);
        txtTitle = findViewById(R.id.txtTitle);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);
        txtDesc = findViewById(R.id.txtDesc);

//        Glide.with(this)
//                .load(list.get(0).getFoto())
//                .placeholder(R.drawable.noimg)
//                .into(imgEvent);
    }

    public void back(View view) {
        finish();
    }

    public void pembayaran(View view) {
    }
}
