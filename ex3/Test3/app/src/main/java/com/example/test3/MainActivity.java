package com.example.test3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView tvSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 设置 Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvSample = findViewById(R.id.tvSample);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        // 默认勾选
        checkMenuItem(menu, R.id.action_size_medium);
        checkMenuItem(menu, R.id.action_color_black);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_size_small) {
            setFontSize(10);
            checkMenuItem(item);
            showToast("已设置为小（10sp）");
        } else if (id == R.id.action_size_medium) {
            setFontSize(16);
            checkMenuItem(item);
            showToast("已设置为中（16sp）");
        } else if (id == R.id.action_size_large) {
            setFontSize(20);
            checkMenuItem(item);
            showToast("已设置为大（20sp）");
        } else if (id == R.id.action_normal_item) {
            showToast("这是一个普通菜单项");
        } else if (id == R.id.action_color_red) {
            setFontColor(Color.parseColor("#e53935"));
            checkMenuItem(item);
            showToast("已设置为红色");
        } else if (id == R.id.action_color_black) {
            setFontColor(Color.BLACK);
            checkMenuItem(item);
            showToast("已设置为黑色");
        } else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }

    private void setFontSize(float sp) {
        if (tvSample != null) tvSample.setTextSize(sp);
    }

    private void setFontColor(int color) {
        if (tvSample != null) tvSample.setTextColor(color);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void checkMenuItem(MenuItem item) {
        item.setChecked(true);
    }

    private void checkMenuItem(Menu menu, int id) {
        MenuItem item = menu.findItem(id);
        if (item != null) item.setChecked(true);
    }
}
