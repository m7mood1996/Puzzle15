package com.mahmood_anas.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.util.TimingLogger;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    GameBoard gameBoard;
    Button startGame;
    SharedPreferences sp;
    MediaPlayer mediaPlayer;
    boolean newGame;
    TextView ides[];
    TextView moves;
    TextView time;
    String returntime;
    Context context;
    boolean musicOn;
    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        startGame = findViewById(R.id.start_game);
        mediaPlayer = MediaPlayer.create(this,R.raw.ring);
        sp = getSharedPreferences("MyPref",MODE_PRIVATE);
        musicOn = sp.getBoolean("Music",false);
        ides = new TextView[16];
        init_ides(ides);
        newGame = false;
        context = this;
        moves = findViewById(R.id.moves_num);
        time = findViewById(R.id.timer);
        gameBoard = new GameBoard(ides,moves,time,this);
        flag = false;


        playMus();
        th();

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameBoard = new GameBoard(ides,moves,time,context);
                gameBoard.moves.setText("0000");
                newGame = true;
                gameBoard.resetGame();
                gameBoard.shuffle();

                while(gameBoard.isSolved() == false) {
                    gameBoard.shuffle();
                }
            }
        });



            gameBoard.array[0].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[0]);

                }
            });

            gameBoard.array[1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[1]);

                }
            });

            gameBoard.array[2].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[2]);

                }
            });

            gameBoard.array[3].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[3]);

                }
            });

            gameBoard.array[4].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[4]);

                }
            });

            gameBoard.array[5].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[5]);

                }
            });

            gameBoard.array[6].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[6]);

                }
            });

            gameBoard.array[7].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[7]);

                }
            });

            gameBoard.array[8].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[8]);

                }
            });

            gameBoard.array[9].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[9]);

                }
            });

            gameBoard.array[10].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[10]);

                }
            });

            gameBoard.array[11].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[11]);

                }
            });

            gameBoard.array[12].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[12]);

                }
            });

            gameBoard.array[13].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[13]);

                }
            });

            gameBoard.array[14].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[14]);

                }
            });

            gameBoard.array[15].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                gameBoard.swap(gameBoard.array[15]);
                if(gameBoard.woned == true){

                }
                }
            });








    }

    private void playMus() {

        if(musicOn){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    while(musicOn) {
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
    public void onPause() {
            super.onPause();
            flag = true;
        if (mediaPlayer.isPlaying()) {
            musicOn =false;
            mediaPlayer.reset();

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        flag = true;
        if (mediaPlayer.isPlaying()) {
            musicOn =false;
            mediaPlayer.reset();

        }
    }

    public void init_ides(TextView ides[]){
        ides[0] = findViewById(R.id.m1x1);
        ides[1] = findViewById(R.id.m1x2);
        ides[2] = findViewById(R.id.m1x3);
        ides[3] = findViewById(R.id.m1x4);
        ides[4] = findViewById(R.id.m2x1);
        ides[5] = findViewById(R.id.m2x2);
        ides[6] = findViewById(R.id.m2x3);
        ides[7] = findViewById(R.id.m2x4);
        ides[8] = findViewById(R.id.m3x1);
        ides[9] = findViewById(R.id.m3x2);
        ides[10] = findViewById(R.id.m3x3);
        ides[11] = findViewById(R.id.m3x4);
        ides[12] = findViewById(R.id.m4x1);
        ides[13] = findViewById(R.id.m4x2);
        ides[14] = findViewById(R.id.m4x3);
        ides[15] = findViewById(R.id.m4x4);


    }
    public void th(){
        new Thread(new Runnable() {

            public void run() {

                    while(true){
                        if(newGame == true){
                            returntime = "00:00";
                            try {
                                Thread.sleep(100);
                            }
                            catch (Exception e){

                            }
                            newGame = false;
                        }

                        else
                            returntime = gameBoard.updateTime();

                        if(gameBoard.woned) {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(context,"Game Over - Puzzle Solved!",Toast.LENGTH_SHORT).show();
                                }

                            });

                            while (gameBoard.woned)
                                if (newGame == true) {
                                    break;
                                }
                        }


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                time.setText(returntime);
                            }

                        });
                        
                    }





            }

        }).start();
    }



}
