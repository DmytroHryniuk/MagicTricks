package com.dev.magictricks;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class FinishActivity extends AppCompatActivity {
    protected void fullSCreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    private long backPressedTime;
    private Toast backToast;
    private VideoView mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        fullSCreen();
        mVideoView=findViewById(R.id.videoView);

        Uri videoUri= Uri.parse(getIntent().getExtras().getString("videoUri"));
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){

            public void onCompletion(MediaPlayer mp)
            {

                //Toast.makeText(PlaybackActivity.this, "ewfwef", Toast.LENGTH_SHORT).show();
                Button btn = (Button) findViewById(R.id.StartAgain);
                btn.setVisibility(View.VISIBLE);


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

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            moveTaskToBack(true);
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Натисніть ще раз для виходу", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    public void StartNew(View view) {
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
}
