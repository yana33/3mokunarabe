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

    String winner = "";

    int sum_maru = 0;
    int sum_batu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Mainアクティビティーから結果を受け取る
        Intent intent = getIntent();
        //String型で受け取り
        winner = intent.getStringExtra("WINNER");

        //textView使う時に書く
        //idに注意！
        TextView textView = (TextView) findViewById(R.id.textView2);
        //受け取った結果を表示
        textView.setText(winner + "の勝ち");

        countWin(winner);

        button_againBattle = (Button) findViewById(R.id.button_againBattle);
        button_againBattle.setOnClickListener(this);
    }

    public void onClick(View v) {

        //MainActivityに移る
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void countWin(String mark) {
        //textView使う時に書く
        TextView textView_maru = (TextView) findViewById(R.id.textView3);
        TextView textView_batu = (TextView) findViewById(R.id.textView4);

        //◯と×それぞれの価値回数を入れる変数を用意して、まるばつそれぞれカウントして変数に1ずつ加算
        if(winner.equals("◯")){
            sum_maru++;
            textView_maru.setText("◯の勝った回数" + String.valueOf(sum_maru));
        }else if(winner.equals("×")){
            sum_batu++;
            textView_batu.setText("×の勝った回数" + String.valueOf(sum_batu));
        }
    }
}
