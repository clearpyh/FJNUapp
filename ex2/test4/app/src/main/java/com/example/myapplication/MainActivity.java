package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnOneWay;
    private Button btnTraveller;
    private Button btnDepart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 绑定控件
        btnOneWay = findViewById(R.id.btn_oneway);
        btnTraveller = findViewById(R.id.btn_traveller);
        btnDepart = findViewById(R.id.btn_depart);

        // 事件绑定
        btnOneWay.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "已选择单程航班", Toast.LENGTH_SHORT).show());

        btnTraveller.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "目前选择1位旅客", Toast.LENGTH_SHORT).show());

        btnDepart.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "🚀 起飞前往火星！", Toast.LENGTH_SHORT).show());
    }
}
