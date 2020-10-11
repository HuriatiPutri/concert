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
    TextView txtTitle, txtDate, txtTime, txtDesc, txtJumlahNormal,txtJumlahNormal2,txtJumlahNormal3, txtTiket, txtMnchds;
    TextView price, price2, price3;
    int tiket1 = 0;
    int tiket2 = 0;
    int totTiket = 0;
    int marchandise = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        imgEvent = findViewById(R.id.imgEvent);
        txtTitle = findViewById(R.id.txtTitle);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);
        txtDesc = findViewById(R.id.txtDesc);
        txtJumlahNormal = findViewById(R.id.jmlhNormal);
        txtJumlahNormal2 = findViewById(R.id.jmlhNormal2);
        txtJumlahNormal3 = findViewById(R.id.jmlhNormal3);
        txtTiket = findViewById(R.id.totTiket);
        txtMnchds = findViewById(R.id.totMchns);

        price = findViewById(R.id.price);
        price2 = findViewById(R.id.normal_price);
        price3 = findViewById(R.id.price3);

        String img = getIntent().getStringExtra("img");
        String title = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("desc");
        String time = getIntent().getStringExtra("time");
        String date = getIntent().getStringExtra("date");

        txtTiket.setText("Rp. 0");
        txtMnchds.setText("Rp. 0");

        txtTitle.setText(title);
        txtDate.setText(date);
        txtTime.setText(time);
        txtDesc.setText(desc);

        Glide.with(this)
                .load(img)
                .placeholder(R.drawable.noimg)
                .into(imgEvent);
    }

    public void back(View view) {
        finish();
    }

    public void pembayaran(View view) {
    }

    public void minus1(View view) {
        int tot = Integer.parseInt(txtJumlahNormal.getText().toString());
        if(tot > 0){
            totTiket = tiket1+tiket2;
            tot = tot - 1;
            tiket1 = (tot * 50000);
            txtJumlahNormal.setText(tot+"");
            txtTiket.setText("Rp. " + totTiket);
        }
    }

    public void plus1(View view) {
        int tot = Integer.parseInt(txtJumlahNormal.getText().toString());
        if(tot >= 0){
            tot = tot + 1;
            txtJumlahNormal.setText(tot+"");
            tiket1 = (tot * 50000);
            totTiket = tiket1+tiket2;
            txtTiket.setText("Rp. " + totTiket);
        }
    }

    public void min2(View view) {
        int tot = Integer.parseInt(txtJumlahNormal2.getText().toString());
        if(tot > 0){
            tot = tot - 1;
            tiket2 = (tot * 50000);
            totTiket = tiket1+tiket2;
            txtJumlahNormal2.setText(tot+"");
            txtTiket.setText("Rp. " + totTiket);
        }
    }

    public void plus2(View view) {
        int tot = Integer.parseInt(txtJumlahNormal2.getText().toString());
        if(tot >= 0){
            tot = tot + 1;
            txtJumlahNormal2.setText(tot+"");
            tiket2 =  (tot * 50000);
            totTiket = tiket1+tiket2;
            txtTiket.setText("Rp. " + totTiket);
        }
    }
    public void minus3(View view) {
        int tot = Integer.parseInt(txtJumlahNormal3.getText().toString());
        if(tot > 0){
            tot = tot - 1;
            marchandise = (tot * 150000);
            txtJumlahNormal3.setText(tot+"");
            txtMnchds.setText("Rp. " + marchandise);
        }
    }

    public void plus3(View view) {
        int tot = Integer.parseInt(txtJumlahNormal3.getText().toString());
        if(tot >= 0){
            tot = tot + 1;
            marchandise = (tot * 150000);
            txtJumlahNormal3.setText(tot+"");
            txtMnchds.setText("Rp. " + marchandise);
        }
    }
}
