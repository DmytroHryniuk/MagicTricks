package com.dev.magictricks;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    private static int VIDEO_REQUEST = 100;
    private static int VIDEO_REQUEST1 = 101;
    private static int VIDEO_REQUEST2 = 102;
    private static int VIDEO_REQUEST3 = 103;
    private static int VIDEO_REQUEST4 = 104;
    private Uri videoUri = null;
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
        setContentView(R.layout.activity_game);
        fullSCreen();


    }

    public void captureVideo(View view) {
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (videoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(videoIntent, VIDEO_REQUEST);
        }
    }

    public void playVideo(View view) {
        Intent playintent = new Intent(this, PlaybackActivity.class);
        playintent.putExtra("videoUri", videoUri.toString());
        playintent.putExtra("videoUri_1", videoUri_1.toString());
        playintent.putExtra("videoUri_2", videoUri_2.toString());
        playintent.putExtra("videoUri_3", videoUri_3.toString());
        playintent.putExtra("videoUri_4", videoUri_4.toString());
        startActivity(playintent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == VIDEO_REQUEST && resultCode == RESULT_OK) {
            videoUri = data.getData();
            TextView editText =(TextView) findViewById(R.id.stat_osn);
            editText.setText(getString(R.string.ready));

        }
        else if(requestCode == VIDEO_REQUEST1 && resultCode == RESULT_OK){
            videoUri_1 = data.getData();
            TextView editText =(TextView) findViewById(R.id.stat_first);
            editText.setText(getString(R.string.ready));
        }
        else if(requestCode == VIDEO_REQUEST2 && resultCode == RESULT_OK){
            videoUri_2 = data.getData();
            TextView editText =(TextView) findViewById(R.id.stat_sec);
            editText.setText(getString(R.string.ready));
        }
        else if(requestCode == VIDEO_REQUEST3 && resultCode == RESULT_OK){
            videoUri_3 = data.getData();
            TextView editText =(TextView) findViewById(R.id.stat_three);
            editText.setText(getString(R.string.ready));
        }
        else if(requestCode == VIDEO_REQUEST4 && resultCode == RESULT_OK){
            videoUri_4 = data.getData();
            TextView editText =(TextView) findViewById(R.id.stat_forth);
            editText.setText(getString(R.string.ready));
        }
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
        if (videoUri!=null &&  videoUri_1!=null && videoUri_2!=null && videoUri_3!=null && videoUri_4!=null){ //
            Button btn = (Button) findViewById(R.id.startBtn);
            btn.setVisibility(View.VISIBLE);
        }
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

    public void VideoCapture_1(View view) {
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (videoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(videoIntent, VIDEO_REQUEST1);
        }
    }
    public void VideoCapture_2(View view) {
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (videoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(videoIntent, VIDEO_REQUEST2);
        }
    }
    public void VideoCapture_3(View view) {
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (videoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(videoIntent, VIDEO_REQUEST3);
        }
    }
    public void VideoCapture_4(View view) {
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (videoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(videoIntent, VIDEO_REQUEST4);
        }
    }

}
