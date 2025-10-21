package com.example.test2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 假设你的界面上有一个按钮点击显示登录框
        Button showDialogBtn = findViewById(R.id.showDialogBtn);
        showDialogBtn.setOnClickListener(v -> showLoginDialog());
    }

    private void showLoginDialog() {
        // 1. 使用 LayoutInflater 加载自定义布局
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.dialog_login, null);

        // 2. 获取布局中的控件
        EditText usernameEt = dialogView.findViewById(R.id.username);
        EditText passwordEt = dialogView.findViewById(R.id.password);
        Button loginBtn = dialogView.findViewById(R.id.loginBtn);
        Button cancelBtn = dialogView.findViewById(R.id.cancelBtn);

        // 3. 创建 AlertDialog
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogView)   // 设置自定义布局
                .create();

        // 4. 设置按钮点击事件
        loginBtn.setOnClickListener(v -> {
            String username = usernameEt.getText().toString();
            String password = passwordEt.getText().toString();
            Toast.makeText(MainActivity.this,
                    "用户名: " + username + "\n密码: " + password,
                    Toast.LENGTH_SHORT).show();
            dialog.dismiss();  // 点击登录后关闭对话框
        });

        cancelBtn.setOnClickListener(v -> dialog.dismiss());

        // 5. 显示对话框
        dialog.show();
    }
}
