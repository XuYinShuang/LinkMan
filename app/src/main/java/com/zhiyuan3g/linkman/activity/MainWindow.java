package com.zhiyuan3g.linkman.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhiyuan3g.linkman.R;

public class MainWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnContacts:
                Intent intent = new Intent(MainWindow.this, PhoneActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMedia:
                Intent intent1 = new Intent(MainWindow.this, MediaActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnAudio:
                Intent intent2 = new Intent(MainWindow.this, AudioActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnPic:
                Intent intent3 = new Intent(MainWindow.this, PictureActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
