package com.example.mahe.quickmaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameMenuActivity extends AppCompatActivity {

    Button ngButton,sButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
        ngButton=(Button)findViewById(R.id.ngButton);
        sButton=(Button)findViewById(R.id.sButton);
        ngButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GameMenuActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });
        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GameMenuActivity.this,Scores.class);
                startActivity(intent);
            }
        });
    }
}
