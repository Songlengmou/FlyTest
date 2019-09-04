package com.anningtex.flytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity {
    private View startView, toView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //起始点元素
        startView = findViewById(R.id.btn);
        //结束点元素
        toView = findViewById(R.id.box);
        startView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickK();
            }
        });
    }

    private void clickK() {
        FlyView fly = new FlyView(this, startView, toView, R.mipmap.ic_launcher);
        fly.startFly(3000, new Runnable() {
            @Override
            public void run() {
                //结束点元素动画变化
                toView.animate().scaleX(1.5f);
                toView.animate().scaleY(1.3f);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toView.animate().scaleX(1f);
                        toView.animate().scaleY(1f);
                    }
                }, 200);
            }
        });
    }
}
