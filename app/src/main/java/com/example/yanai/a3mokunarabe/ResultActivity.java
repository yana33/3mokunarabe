package com.example.yanai.a3mokunarabe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;
//intentを使用する時に書く
import android.content.Intent;

public class ResultActivity extends AppCompatActivity implements OnClickListener {

    //ボタンの宣言
    Button button_againBattle;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    String winner = "";
    String result1 = "";
    String result2 = "";
    String result3 = "";
    String result4 = "";
    String result5 = "";
    String result6 = "";
    String result7 = "";
    String result8 = "";
    String result9 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Mainアクティビティーから結果を受け取る
        Intent intent = getIntent();
        //String型で受け取り
        winner = intent.getStringExtra("WINNER");

        result1 = intent.getStringExtra("RESULT1");
        result2 = intent.getStringExtra("RESULT2");
        result3 = intent.getStringExtra("RESULT3");
        result4 = intent.getStringExtra("RESULT4");
        result5 = intent.getStringExtra("RESULT5");
        result6 = intent.getStringExtra("RESULT6");
        result7 = intent.getStringExtra("RESULT7");
        result8 = intent.getStringExtra("RESULT8");
        result9 = intent.getStringExtra("RESULT9");

        button1.setText(result1);
        button2.setText(result2);
        button3.setText(result3);
        button4.setText(result4);
        button5.setText(result5);
        button6.setText(result6);
        button7.setText(result7);
        button8.setText(result8);
        button9.setText(result9);


        //textView使う時に書く
        //idに注意！
        TextView textView = (TextView) findViewById(R.id.textView2);

        //受け取った結果を表示
        textView.setText(winner);

        button_againBattle = (Button) findViewById(R.id.button_againBattle);
        button_againBattle.setOnClickListener(this);
    }

    public void onClick(View v) {

        //MainActivityに移る
        Intent intent = new Intent(ResultActivity.this, StartActivity.class);
        startActivity(intent);
    }

}
