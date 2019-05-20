package com.dev.magictricks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    protected void fullSCreen(){
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
        setContentView(R.layout.activity_main);

        fullSCreen();
    }



    @Override
    protected void onStart(){
        super.onStart();
        //Toast.makeText(this, "START", Toast.LENGTH_SHORT).show();
        fullSCreen();
    }

    @Override
    protected void onResume(){
        super.onResume();
        //Toast.makeText(this, "RESUME", Toast.LENGTH_SHORT).show();
        fullSCreen();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        //Toast.makeText(this, "RESTART", Toast.LENGTH_SHORT).show();
        fullSCreen();
    }

    public void startButton(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
