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
        Intent intent = new Intent(StartActivity.this,MainActivity.class);
        switch (v.getId()){
            case R.id.button_PlayFirst:
                //この行でresultアクティビティーが起動
                startActivity(intent);
                break;

            case R.id.button_DrawFirst:
                startActivity(intent);
        }
    }
}
