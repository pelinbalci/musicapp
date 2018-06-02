package com.example.android.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Toshiba on 4/4/2018.
 */

public class NowPlaying extends AppCompatActivity {

    TextView finalTextView1;
    TextView finalTextView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);
        Intent incoming = getIntent();

        if (incoming == null)
            return;

        finalTextView1 = findViewById(R.id.song_now_playing);
        finalTextView2 = findViewById(R.id.singer_now_playing);
        finalTextView1.setText(incoming.getStringExtra("message_key1"));
        finalTextView2.setText(incoming.getStringExtra("message_key2"));


        ImageView backButton = (ImageView) findViewById(R.id.backButton2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(NowPlaying.this, TrackActivity.class);
                backIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(backIntent);
            }

        });

    }
}
