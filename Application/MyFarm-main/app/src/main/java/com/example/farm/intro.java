package com.example.farm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        introThread introThread = new introThread(handler);
        introThread.start();
    }

    /* intro에서 thread 호출.
    *  intro에 start() 메소드를 통해 introThread에 run() 메소드가 실행
    *  introThread에 sleep() 메소드가 종료되면 introThread에 sendEmptyMessage() 메소드를 통해 handleMessage() 메소드가 호출되며 message 값을 전달받는다
    *  handleMessage() 메소드 호출을 통해 전달받은 message 값을 검사
    *  전달받은 값이 1과 같다면 intent를 사용해 intro -> LoginActivity로 화면 전환 */
    Handler handler = new Handler() {
        @Override
        public  void handleMessage(Message msg) {
            if (msg.what == 1) {
                Intent intent = new Intent(intro.this, LoginActivity.class);
                startActivity(intent);
            }
        }
    };
}
