package com.example.concertonline.ui.detail_watch;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.concertonline.R;

public class DetailVrActivity extends AppCompatActivity {

    String vidAddress = "https://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4";
    Uri vidUri = Uri.parse(vidAddress);
    TextView btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vr);

        btnClose = (TextView)findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        VideoView vidView = (VideoView)findViewById(R.id.myVideo);

        vidView.setVideoURI(vidUri);
        vidView.start();
    }
}