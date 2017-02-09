package com.example.yanai.a3mokunarabe;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;
//intentを使用する時に書く
import android.content.Intent;

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
    Button button_reset;

    //自分のターンか相手のターンかの２択だからboolean型
    //とりあえず、自分のターンからとしてtrue
    boolean isMyTurn = true;

    //ボタンを押した回数をカウントする
    int turnCount = 0;

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

        button_reset = (Button) findViewById(R.id.button_reset);
        button_reset.setOnClickListener(this);

    }

    //viewはアクティビティーにのっているもの。とりあえず、引数はView
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_reset:
                //resetボタンを押した時
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                button5.setText("");
                button6.setText("");
                button7.setText("");
                button8.setText("");
                button9.setText("");
                //ここでreset押した時にボタンを押した回数のカウントを0に戻す
                turnCount = 0;
                //ボタンをもう一度押せるようにする
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                button5.setEnabled(true);
                button6.setEnabled(true);
                button7.setEnabled(true);
                button8.setEnabled(true);
                button9.setEnabled(true);
                break;
            default:
                //defaultでcaseに当てはまらなかった場合のすべての場合の処理を指定
                //setButton()の()内が丸っと引数
                //v.getId()でボタンのIdを持ってきて、(Button)でButton型に変換
                setButtonText((Button) findViewById(v.getId()));
                break;
        }
    }

    //ここでなんのボタンを押したか、受け取って判断
    public void setButtonText(Button button) {
        if (isMyTurn) {
            button.setText("◯");
            //ここで毎回、勝敗の判定
            //◯を引数としてdecideWinnerに渡す
            decideWinner("◯");
        } else {
            button.setText("×");
            //ここで毎回、勝敗の判定
            decideWinner("×");
        }
        //!は反転。if文を抜けたら自然とtrueとfalseが入れ替わるように
        //isMyTurnは変数名
        isMyTurn = !isMyTurn;
        //ここで１度押したボタンを押せなくする
        //ここでは上で引数としてどのボタンを押したか指定してあるからbuttonで大丈夫
        button.setEnabled(false);

        //ボタンを何回押したかカウント
        turnCount++;
    }

    //揃ったかを判定して、勝ち負けを判定。textViewに表示する
    public void decideWinner(String symbol) {

        //条件が揃うまでは勝敗を決められないから、winnerはfalse
        //「||(or)」はどちらかがtrueになったら、trueになるから、どれか()内の条件が揃ったら,boolean型のwinnerはtrueになる
        boolean winner = false;
        winner = winner || (button1.getText() == symbol && button4.getText() == symbol && button7.getText() == symbol);
        winner = winner || (button2.getText() == symbol && button5.getText() == symbol && button8.getText() == symbol);
        winner = winner || (button3.getText() == symbol && button6.getText() == symbol && button9.getText() == symbol);
        winner = winner || (button1.getText() == symbol && button2.getText() == symbol && button3.getText() == symbol);
        winner = winner || (button4.getText() == symbol && button5.getText() == symbol && button6.getText() == symbol);
        winner = winner || (button7.getText() == symbol && button8.getText() == symbol && button9.getText() == symbol);
        winner = winner || (button1.getText() == symbol && button5.getText() == symbol && button9.getText() == symbol);
        winner = winner || (button3.getText() == symbol && button5.getText() == symbol && button7.getText() == symbol);

        if(winner){
            //ResultActivityに移る
            //Intentはアクティビティー間の橋渡し
            //Intent(今いるアクティビティー.this,移る先のアクティビティー.class)
            Intent intent = new Intent(MainActivity.this,ResultActivity.class);

            //putExtraの第一引数は、キー名です。第二引数が、渡したい値です。
            //渡したい値をキー名にコピーしてresultアクティビティに渡す
            intent.putExtra("WINNER",symbol + "の勝ち");

            //この行でresultアクティビティーが起動
            startActivity(intent);
        }

        //引き分けの場合の処理
        if(turnCount == 8){
            Intent intent = new Intent(MainActivity.this,ResultActivity.class);
            intent.putExtra("WINNER","引き分け");
            startActivity(intent);
        }

        //勝敗のカウントがリセットされるところは置いといて、引き分けの対応を考える
    }
}
