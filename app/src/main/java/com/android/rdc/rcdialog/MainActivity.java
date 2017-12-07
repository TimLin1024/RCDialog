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
                        .setCancelable(true)//按物理返回键或者点击窗口外部区域时是否取消显示
                        .setCanceledOnTouchOutside(true)//点击窗口外部时是否取消显示（默认为 true，将它设置为 true 时，会默认将 setCancelable 设置为 true）
                        .setTitle("提示")//设置标题
                        .setMsg("Hello Round Rect Dialog")//设置内容
                        .setNegativeButton("取消", null)//设置左侧按钮的提示文字，以及点击事件监听
                        .setGravity(Gravity.BOTTOM)//设置显示位置（默认为 bottom）
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {//设置右侧按钮的提示文字，以及点击事件监听
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Click Sure", Toast.LENGTH_SHORT).show();
                            }
                        }).show();//设置显示出 Dialog。show 方法，显示出 dialog
            }
        });
    }
}
