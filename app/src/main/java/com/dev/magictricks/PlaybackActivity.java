package com.dev.magictricks;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class PlaybackActivity extends AppCompatActivity {
private VideoView mVideoView;
    private Uri videoMy1 = null;
    private Uri videoUri_1 = null;
    private Uri videoUri_2 = null;
    private Uri videoUri_3 = null;
    private Uri videoUri_4 = null;
    protected void fullSCreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playback);
        fullSCreen();
        mVideoView=findViewById(R.id.videoView);


        videoMy1=Uri.parse(getIntent().getExtras().getString("videoUri"));
        Uri videoUri= Uri.parse(getIntent().getExtras().getString("videoUri"));

        videoUri_1=Uri.parse(getIntent().getExtras().getString("videoUri_1"));
        videoUri_2=Uri.parse(getIntent().getExtras().getString("videoUri_2"));
        videoUri_3=Uri.parse(getIntent().getExtras().getString("videoUri_3"));
        videoUri_4=Uri.parse(getIntent().getExtras().getString("videoUri_4"));

        mVideoView.setVideoURI(videoUri);
        mVideoView.start();

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mp)
            {

                //Toast.makeText(PlaybackActivity.this, "ewfwef", Toast.LENGTH_SHORT).show();
                Button btn1 = (Button) findViewById(R.id.video1);
                btn1.setVisibility(View.VISIBLE);
                Button btn2 = (Button) findViewById(R.id.video2);
                btn2.setVisibility(View.VISIBLE);
                Button btn3 = (Button) findViewById(R.id.video3);
                btn3.setVisibility(View.VISIBLE);
                Button btn4 = (Button) findViewById(R.id.video4);
                btn4.setVisibility(View.VISIBLE);

            }

        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        //Toast.makeText(this, "START", Toast.LENGTH_SHORT).show();
        fullSCreen();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "RESUME", Toast.LENGTH_SHORT).show();
        fullSCreen();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Toast.makeText(this, "RESTART", Toast.LENGTH_SHORT).show();
        fullSCreen();
    }

    public void video1btn(View view) {

        Intent playintent = new Intent(this, FinishActivity.class);
        playintent.putExtra("videoUri", videoUri_1.toString());
        startActivity(playintent);

    }
    public void video2btn(View view) {

        Intent playintent = new Intent(this, FinishActivity.class);
        playintent.putExtra("videoUri", videoUri_2.toString());
        startActivity(playintent);

    }
    public void video3btn(View view) {

        Intent playintent = new Intent(this, FinishActivity.class);
        playintent.putExtra("videoUri", videoUri_3.toString());
        startActivity(playintent);

    }
    public void video4btn(View view) {

        Intent playintent = new Intent(this, FinishActivity.class);
        playintent.putExtra("videoUri", videoUri_4.toString());
        startActivity(playintent);

    }
}
