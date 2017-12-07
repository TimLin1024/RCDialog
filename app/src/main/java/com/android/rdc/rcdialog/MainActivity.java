package com.android.rdc.rcdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RoundRectDialog.Builder(MainActivity.this)
                        .setCancelable(true)
                        .setTitle("提示")
                        .setMsg("Hello Round Rect Dialog")
                        .setNegativeButton("取消", null)
                        .setGravity(Gravity.CENTER)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Click Sure", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }
}
