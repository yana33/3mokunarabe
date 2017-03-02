package com.example.yanai.a3mokunarabe;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
//intentを使用する時に書く
import android.content.Intent;
//ランダム関数を使用する時に書く！
import java.util.Random;

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

    //ここで値を受け取るための変数を作っておく！受け取る部分とまとめると、実行されない時にこの変数って何？？ってなっちゃうから
    String turn = "";

    //自分のターンか相手のターンかの２択だからboolean型
    //とりあえず、自分のターンからとしてtrue
    String isMyTurn = "◯";


    //ボタンを押した回数をカウントする
    int turnCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //この２行はonCreateの中に書く！onCreateは画面ができる瞬間だから、その時に前の画面の値を渡せるように！
        //Mainアクティビティーから結果を受け取る
        Intent intent = getIntent();
        //String型で受け取り
        turn = intent.getStringExtra("TURN");



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


        switch (turn) {
            case "◯":
                //自分が先攻（自分が◯）
                isMyTurn = "◯";
                break;
            case "×":
                //ここで◯をランダムに１つ打つように！
                setMaru();

                //PCが先攻（自分が×）
                isMyTurn = "×";

                break;
            default:
                isMyTurn = "";
                break;
        }
    }

    //はじめの◯を一つ、ランダムに打つメソッド
    public void setMaru(){
        Random rnd = new Random();

        //まずは、ランダムな数字を出す！乱数の範囲は１から９だから0〜8
        int number = rnd.nextInt(8);

        switch (number) {
            case 0:
                if (button1.getText() == "") {
                    button1.setText("◯");
                    //ボタンを無効にする
                    button1.setEnabled(false);
                }
                break;
            case 1:
                if (button2.getText() == "") {
                    button2.setText("◯");
                    button2.setEnabled(false);
                }
                break;
            case 2:
                if (button3.getText() == "") {
                    button3.setText("◯");
                    button3.setEnabled(false);
                }
                break;
            case 3:
                if (button4.getText() == "") {
                    button4.setText("◯");
                    button4.setEnabled(false);
                }
                break;
            case 4:
                if (button5.getText() == "") {
                    button5.setText("◯");
                    button5.setEnabled(false);
                }
                break;
            case 5:
                if (button6.getText() == "") {
                    button6.setText("◯");
                    button6.setEnabled(false);
                }
                break;
            case 6:
                if (button7.getText() == "") {
                    button7.setText("◯");
                    button7.setEnabled(false);
                }
                break;
            case 7:
                if (button8.getText() == "") {
                    button8.setText("◯");
                    button8.setEnabled(false);
                }
                break;
            case 8:
                if (button9.getText() == "") {
                    button9.setText("◯");
                    button9.setEnabled(false);
                }
                break;
            default:
                //とりあえず
                button9.setEnabled(false);;
        }
    }


    //viewはアクティビティーにのっているもの。とりあえず、引数はView
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_reset:
                //resetボタンを押した時

                //1_ボタンをまっさらに戻す
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                button5.setText("");
                button6.setText("");
                button7.setText("");
                button8.setText("");
                button9.setText("");
                //2_ここでreset押した時にボタンを押した回数のカウントを0に戻す
                turnCount = 0;
                //3_そして、ボタンをもう一度押せるようにする
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
        if (isMyTurn == "◯") {
            //↑（）内がtrueならこのかっこ内が実行される。falseのときは、実行されずに丸っとスルー

            //◯は自分が先攻だから、×と違って自分からボタンを選択

            button.setText("◯");
            //ここで毎回、勝敗の判定
            //◯を引数としてdecideWinnerに渡す
            decideWinner("◯");

            //turnCountが0〜3の4回のときは、×を自動で打つように
            if (turnCount <= 3) {
                //はじめはsetPCturnは実行されるようにtrueにしておく
                boolean b1 = true;
                //setPCturnに行った時に、×が打てなかったらtrueを返すことになっているから、もう一度setPCtrunが実行
                //×が打てたらfalseを返してbに格納することになっているから、while文を抜けることができる
                while (b1) {
                    b1 = setPCturn("×");
                }
                //勝敗の判定
                decideWinner("×");
            }
            //ここで◯が１度押したボタンを押せなくする
            //ここでは上で引数としてどのボタンを押したか指定してあるからbuttonで大丈夫
            button.setEnabled(false);
            //これを書くことで×を押した回数をカウント
            //◯の５回目を押したとき、見えないけど×が5になるから上のループを抜ける
            turnCount++;

        } else if (isMyTurn == "×") {

            //turnCountが0〜3の4回のときは、◯を自動で打つように
            if (turnCount <= 3) {
                //はじめはsetPCturnは実行されるようにtrueにしておく
                boolean b2 = true;

                //setPCturnに行った時に、×が打てなかったらtrueを返すことになっているから、もう一度setPCtrunが実行
                //×が打てたらfalseを返してbに格納することになっているから、while文を抜けることができる
                while (b2) {
                    b2 = setPCturn("◯");
                    android.util.Log.d("kokodayo", "b2は " + b2);
                }
                decideWinner("◯");
            }

            button.setText("×");
            decideWinner("×");

            button.setEnabled(false);

            //ボタンを何回押したかカウント ×の回数
            turnCount++;

        }
    }


        //×をつける時はランダムに打つ！けど、◯とか×が付いていないことが条件！
        //Rondom関数はInt型で！
        //×用のメソッドを作成！乱数も使えるように！

    public boolean setPCturn(String symbol_a) {
        Random rnd = new Random();

        //まずは、ランダムな数字を出す！乱数の範囲は１から９だから0〜8
        int number = rnd.nextInt(8);
        android.util.Log.d("kokodayo", "変数numberは " + number);

        //そしたら、ランダムに出た数字で、×を打つボタンを決定。switchで一つずつ×を打っていく
        //ボタンに◯か×がないといは×をつけれるように
        switch (number) {
            case 0:
                if (button1.getText() == "") {
                    //もしボタンが真っ白だったら、受け取った◯または×をボタンにセット
                    button1.setText(symbol_a);
                    //ボタンを無効にする
                    button1.setEnabled(false);
                    return false;
                } else {
                    //真っ白じゃなかったら、trueを返す
                    return true;
                }
            case 1:
                if (button2.getText() == "") {
                    button2.setText(symbol_a);
                    button2.setEnabled(false);
                    return false;
                } else {
                    return true;
                }
            case 2:
                if (button3.getText() == "") {
                    button3.setText(symbol_a);
                    button3.setEnabled(false);
                    return false;
                } else {
                    return true;
                }
            case 3:
                if (button4.getText() == "") {
                    button4.setText(symbol_a);
                    button4.setEnabled(false);
                    return false;
                } else {
                    return true;
                }
            case 4:
                if (button5.getText() == "") {
                    button5.setText(symbol_a);
                    button5.setEnabled(false);
                    return false;
                } else {
                    return true;
                }
            case 5:
                if (button6.getText() == "") {
                    button6.setText(symbol_a);
                    button6.setEnabled(false);
                    return false;
                } else {
                    return true;
                }
            case 6:
                if (button7.getText() == "") {
                    button7.setText(symbol_a);
                    button7.setEnabled(false);
                    return false;
                } else {
                    return true;
                }
            case 7:
                if (button8.getText() == "") {
                    button8.setText(symbol_a);
                    button8.setEnabled(false);
                    return false;
                } else {
                    return true;
                }
            case 8:
                if (button9.getText() == "") {
                    button9.setText(symbol_a);
                    button9.setEnabled(false);
                    return false;
                } else {
                    return true;
                }
            default:
                return true;
        }
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

        if (winner) {
            //ResultActivityに移る
            //Intentはアクティビティー間の橋渡し
            //Intent(今いるアクティビティー.this,移る先のアクティビティー.class)
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);

            //putExtraの第一引数は、キー名です。第二引数が、渡したい値です。
            //渡したい値をキー名にコピーしてresultアクティビティに渡す
            intent.putExtra("WINNER", symbol + "の勝ち");

            //この行でresultアクティビティーが起動
            startActivity(intent);
        } else if (turnCount == 4) {
            //引き分けの場合の処理
            //PC相手で引き分けのとき、先攻がボタンを押すのは最大５回
            //先攻が押したボタンの回数を数えればOK ...だから◯と×の場合分けがいらなくなるのかな？
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("WINNER", "引き分け");
            startActivity(intent);
        }

    }
}
