package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private String expression = "";
    private double result = 0;
    private char lastOp = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.editTextInput);
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        int count = gridLayout.getChildCount();
        for (int i = 0; i < count; i++) {
            Button btn = (Button) gridLayout.getChildAt(i);
            btn.setOnClickListener(v -> handleButtonClick(btn.getText().toString()));
        }
    }

    private void handleButtonClick(String text) {
        switch (text) {
            case "=":
                calculate();
                break;
            case "×":
            case "÷":
            case "+":
            case "-":
                expression += " " + text + " ";
                input.setText(expression);
                break;
            default:
                expression += text;
                input.setText(expression);
        }
    }

    private void calculate() {
        try {
            // 简易表达式计算，只支持一个运算符
            String[] parts = expression.split(" ");
            if (parts.length < 3) return;

            double a = Double.parseDouble(parts[0]);
            String op = parts[1];
            double b = Double.parseDouble(parts[2]);

            switch (op) {
                case "+": result = a + b; break;
                case "-": result = a - b; break;
                case "×": result = a * b; break;
                case "÷": result = b != 0 ? a / b : 0; break;
            }

            input.setText(String.valueOf(result));
            expression = String.valueOf(result);

        } catch (Exception e) {
            input.setText("Error");
            expression = "";
        }
    }
}
