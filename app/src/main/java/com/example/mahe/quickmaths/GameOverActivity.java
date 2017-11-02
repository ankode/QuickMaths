package com.example.mahe.quickmaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileOutputStream;

public class GameOverActivity extends AppCompatActivity {

    Button ngButton, menuButton;
    TextView fs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        fs=(Button)findViewById(R.id.fs);
        int finalScore=(int)getIntent().getExtras().get("score");
        fs.setText(finalScore);
        ngButton=(Button)findViewById(R.id.ngButton);
        menuButton=(Button)findViewById(R.id.menuButton);
        FileOutputStream fOut = openFileOutput("scores",MODE_PRIVATE);

        ngButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GameOverActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(GameOverActivity.this,GameMenuActivity.class);
                startActivity(intent);
            }
        });
    }

}
