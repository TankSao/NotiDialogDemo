package com.example.administrator.notidialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (TextView)findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        String msg = "是否清空所有聊天记录\n不可恢复";
        new NotificationDialog(MainActivity.this,null, msg, null,new NotificationDialog.DialogCallBack() {

            @Override
            public void onResult(boolean confirmed, Bundle bundle) {
                if(confirmed){
                    Toast.makeText(MainActivity.this,"确定",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();
                }
            }
        }, true).show();
    }
}
