package com.example.yanai.a3mokunarabe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
//intentを使用する時に書く
import android.content.Intent;

public class StartActivity extends AppCompatActivity implements OnClickListener {

    //ボタンの宣言
    Button button_PlayFirst;
    Button button_DrawFirst;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

       button_PlayFirst = (Button) findViewById(R.id.button_PlayFirst);
       button_PlayFirst.setOnClickListener(this);

       button_DrawFirst = (Button) findViewById(R.id.button_DrawFirst);
       button_DrawFirst.setOnClickListener(this);
    }

    public void onClick(View v) {
        //Intent(今いるアクティビティー.this,移る先のアクティビティー.class)
        Intent intent = new Intent(StartActivity.this,MainActivity.class);
        switch (v.getId()){
            case R.id.button_PlayFirst:

                //putExtraの第一引数は、キー名。第二引数が、渡したい値。
                //渡したい値をキー名にコピーしてresultアクティビティに渡す
                intent.putExtra("TURN","◯");

                //この行でMainアクティビティーが起動
                startActivity(intent);
                break;

            case R.id.button_DrawFirst:

                intent.putExtra("TURN","×");
                startActivity(intent);
                break;
            default:
                intent.putExtra("TURN","");

                //この行でMainアクティビティーが起動
                startActivity(intent);
                break;
        }
    }
}
