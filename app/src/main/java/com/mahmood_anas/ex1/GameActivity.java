package com.mahmood_anas.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    GameBoard gameBoard;
    Button StartGame;
    SharedPreferences sp;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        StartGame = findViewById(R.id.start_game);
        mediaPlayer = MediaPlayer.create(this,R.raw.ring);
        sp = getSharedPreferences("MyPref",MODE_PRIVATE);
        boolean musicOn = sp.getBoolean("Music",false);
        if(musicOn){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    while(true) {
                        if(mediaPlayer.isPlaying() == false)
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mediaPlayer.start();
                                }
                            });
                    }
                }
            }).start();

        }





    }

    @Override
    public void onBackPressed() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.reset();
        }

            super.onBackPressed();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start_game){
            randomPuzzle();
        }
    }

    private void randomPuzzle(){
    gameBoard.changeArray();
    }
}
