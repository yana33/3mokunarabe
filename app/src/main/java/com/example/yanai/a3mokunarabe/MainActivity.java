package com.example.yanai.a3mokunarabe;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    //ボタンの宣言
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    //自分のターンか相手のターンかの２択だからboolean型
    //とりあえず、自分のターンからとしてtrue
    boolean isMyTurn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }

    //viewはアクティビティーにのっているもの。とりあえず、引数はView
    public void onClick(View v) {
        //setButton()の()内が丸っと引数
        //v.getId()でボタンのIdを持ってきて、(Button)でButton型に変換
        setButtonText((Button) findViewById(v.getId()));
    }

    //ここでなんのボタンを押したか、受け取って判断
    public void setButtonText(Button button) {
        if (isMyTurn) {
            button.setText("◯");
        } else {
            button.setText("×");
        }
        //!は反転。if文を抜けたら自然とtrueとfalseが入れ替わるように
        //isMyTurnは変数名
        isMyTurn = !isMyTurn;
        //ここで１度押したボタンを押せなくする
        button.setEnabled(false);
        decideWinner();
    }

    //揃ったかを判定して、勝ち負けを判定。textViewに表示する
    public void decideWinner() {
        //textView使う時に書く
        TextView textView = (TextView) findViewById(R.id.textView);

        //たて１列が揃ったらtextViewに「◯の勝ち」
        //getTextでボタンに表示される文字を取得
        if (button1.getText() == ("◯") && button4.getText() == ("◯") && button7.getText() == ("◯")) {
            textView.setText("◯の勝ち");
        } else if (button2.getText() == ("◯") && button5.getText() == ("◯") && button8.getText() == ("◯")) {
            textView.setText("◯の勝ち");
        } else if (button3.getText() == ("◯") && button6.getText() == ("◯") && button9.getText() == ("◯")) {
            textView.setText("◯の勝ち");
        } else if (button1.getText() == ("◯") && button2.getText() == ("◯") && button3.getText() == ("◯")) {
            textView.setText("◯の勝ち");
        } else if (button4.getText() == ("◯") && button5.getText() == ("◯") && button6.getText() == ("◯")) {
            textView.setText("◯の勝ち");
        } else if (button7.getText() == ("◯") && button8.getText() == ("◯") && button9.getText() == ("◯")) {
            textView.setText("◯の勝ち");
        } else if (button1.getText() == ("◯") && button5.getText() == ("◯") && button9.getText() == ("◯")) {
            textView.setText("◯の勝ち");
        } else if (button3.getText() == ("◯") && button5.getText() == ("◯") && button7.getText() == ("◯")) {
            textView.setText("◯の勝ち");
        }
    }
}
