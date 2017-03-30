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


        //textView使う時に書く
        //idに注意！
        TextView textView = (TextView) findViewById(R.id.textView2);


        //ビューに対して割り当てられたリソースIDから対応するビューオブジェクトを取得してみます。
        // Activityクラスで定義されているfindViewByIdメソッドを使用します。
        //引数にリソースIDを指定すると、対応するビューのオブジェクトを返します。
        // 実際に使用する時は戻り値をそのビューのクラスでキャストして下さい。
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);


        //受け取った結果を表示
        textView.setText(winner);

        button1.setText(result1);
        button2.setText(result2);
        button3.setText(result3);
        button4.setText(result4);
        button5.setText(result5);
        button6.setText(result6);
        button7.setText(result7);
        button8.setText(result8);
        button9.setText(result9);

        //ボタン押せる状態だと、押した時にonceAgainBattleと同じ処理になるから、ボタンを押せないようにしておく
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);
        button9.setEnabled(false);


        button_againBattle = (Button) findViewById(R.id.button_againBattle);
        button_againBattle.setOnClickListener(this);

    }

    public void onClick(View v) {

        //StartActivityに移る
        Intent intent = new Intent(ResultActivity.this, StartActivity.class);
        startActivity(intent);
    }

}
