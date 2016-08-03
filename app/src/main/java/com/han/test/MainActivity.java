package com.han.test;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.han.view.AutoSizeTextButton;
import com.han.view.AutoSizeTextView;

public class MainActivity extends AppCompatActivity {

    private AutoSizeTextView textView1;
    private AutoSizeTextButton textButton1;
    int count = 0;
    Handler mhandle = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (count > 10) {
                return;
            }
            String newstr = textButton1.getText() + "W";
            textView1.setText(newstr);
            textButton1.setText(newstr);
            mhandle.sendEmptyMessageDelayed(1, 1000);
            count++;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (AutoSizeTextView) findViewById(R.id.text1);
        textButton1 = (AutoSizeTextButton) findViewById(R.id.button1);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mhandle.sendEmptyMessageDelayed(1, 2000);
    }
}
