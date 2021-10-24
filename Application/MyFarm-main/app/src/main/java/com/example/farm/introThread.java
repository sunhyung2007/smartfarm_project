package com.example.farm;

import android.os.Message;

import android.os.Handler;

public class introThread extends Thread{

    private Handler handler;

    /* 생성자를 통해 handler를 전달받는다.
    *  introThread에 Thread.sleep() 메소드가 종료했을 때 메시지를 전달받아야 하기 때문이다. */
    public introThread(Handler handler){
        this.handler = handler;
    }

    @Override
    public void run() {
        /* run() 메소드: 다른 activity 또는 class에서 thread 객체를 생성해 start() 메소드를 호출했을 때 실행되는 메소드 */

        /* run() 메소드 안에 Thread.sleep() 메소드를 사용하고 Thread().sleep 메소드가 종료되었을 때 handler를 통해 message를 전달받을 수 있도록 코드 작성*/
        Message msg = new Message();

        try {
            Thread.sleep(3000);
            msg.what = 1;
            handler.sendEmptyMessage(msg.what);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
