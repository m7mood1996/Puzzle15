package com.mahmood_anas.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    GameBoard gameBoard;
     Button StartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        StartGame = findViewById(R.id.start_game);
        gameBoard =  new GameBoard();
        StartGame.setOnClickListener(this);
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
