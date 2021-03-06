package com.example.concertonline.ui.detail_watch;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.concertonline.R;

public class DetailWatchActivity extends AppCompatActivity {

    String vidAddress = "https://dedykuncoro.com/childrens-song/uploads/videos/japanese_childrens_song_-_okina_kuri_no_ki_no_shita_de.mp4";
    Uri vidUri = Uri.parse(vidAddress);
    TextView btnClose,btnVr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_watch);

        btnClose = (TextView)findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnVr = (TextView)findViewById(R.id.btnVR);
        btnVr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DetailVrActivity.class));
            }
        });
        VideoView vidView = (VideoView)findViewById(R.id.myVideo);

        vidView.setVideoURI(vidUri);
        vidView.start();
    }

}
