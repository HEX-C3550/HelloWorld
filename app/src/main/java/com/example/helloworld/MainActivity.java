package com.example.helloworld;

import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // 1. 绑定 XML 中的组件
        TextView myTextView = findViewById(R.id.myTextView);
        Button btnRed = findViewById(R.id.btnRed);
        Button btnGreen = findViewById(R.id.btnGreen);
        Button btnClear = findViewById(R.id.btnClear);

        // 2. 设置红色按钮点击事件
        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setTextColor(Color.RED);
            }
        });

        // 3. 设置绿色按钮点击事件
        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setTextColor(Color.GREEN);
            }
        });

        // 4. 设置清除（恢复）按钮点击事件
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 恢复为默认黑色
                myTextView.setTextColor(Color.BLACK);
            }
        });
    }
}