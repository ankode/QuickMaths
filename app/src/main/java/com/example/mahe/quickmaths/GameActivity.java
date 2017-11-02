package com.example.mahe.quickmaths;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView equation,ans,tl,score;
    Button one,two,three,four,five,six,seven,eight,nine,zero,clear,minus;
    Integer answer,s;
    final CountDownTimer countDownTimer = new CountDownTimer(5000, 10) {

        public void onTick(long millisUntilFinished) {
            String string =String.format("%.2f",(float)millisUntilFinished / 1000);
            tl.setText(string);
        }

        public void onFinish() {
            Intent intent = new Intent(GameActivity.this,GameOverActivity.class);
            intent.putExtra("score",s);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        s =new Integer(-10);
        equation=(TextView)findViewById(R.id.equation);
        ans=(TextView)findViewById(R.id.ans);
        tl=(TextView)findViewById(R.id.tl);
        score=(TextView)findViewById(R.id.score);
        answer=createRandomEquation();
        one=(Button)findViewById(R.id.one);
        two=(Button)findViewById(R.id.two);
        three=(Button)findViewById(R.id.three);
        four=(Button)findViewById(R.id.four);
        five=(Button)findViewById(R.id.five);
        six=(Button)findViewById(R.id.six);
        seven=(Button)findViewById(R.id.seven);
        eight=(Button)findViewById(R.id.eight);
        nine=(Button)findViewById(R.id.nine);
        zero=(Button)findViewById(R.id.zero);
        clear=(Button)findViewById(R.id.c);
        minus=(Button)findViewById(R.id.e);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(ans.getText().toString()+"1");
                if(ans.getText().toString().equals(answer.toString()))
                {
                    newLevel();
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(ans.getText().toString()+"2");
                if(ans.getText().toString().equals(answer.toString()))
                {
                    newLevel();
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(ans.getText().toString()+"3");
                if(ans.getText().toString().equals(answer.toString()))
                {
                    newLevel();
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(ans.getText().toString()+"4");
                if(ans.getText().toString().equals(answer.toString()))
                {
                    newLevel();
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(ans.getText().toString()+"5");
                if(ans.getText().toString().equals(answer.toString()))
                {
                    newLevel();
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(ans.getText().toString() + "6");
                if (ans.getText().toString().equals(answer.toString())) {
                    newLevel();
                }
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(ans.getText().toString()+"7");
                if(ans.getText().toString().equals(answer.toString()))
                {
                    newLevel();
                }
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(ans.getText().toString()+"8");
                if(ans.getText().toString().equals(answer.toString()))
                {
                    newLevel();
                }
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(ans.getText().toString()+"9");
                if(ans.getText().toString().equals(answer.toString()))
                {
                    newLevel();
                }
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText(ans.getText().toString()+"0");
                if(ans.getText().toString().equals(answer.toString()))
                {
                    newLevel();
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText("");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans.setText("-");
            }
        });
        newLevel();

    }
    int createRandomEquation()
    {
        Random random =new Random();
        int n1=random.nextInt(9) + 1,n2=random.nextInt(9)+1,op=random.nextInt(2)+1;
        if(op==1)
        {
            equation.setText(""+n1+"+"+n2);
            return n1+n2;
        }
        else
        {
            equation.setText(""+n1+"-"+n2);
            return n1-n2;
        }
    }

    void newLevel()
    {
        answer=createRandomEquation();
        countDownTimer.cancel();
        countDownTimer.start();
        s+=10;
        score.setText(""+s);
        ans.setText("");

    }
}


