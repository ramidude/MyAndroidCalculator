package com.example.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView textViewDisplayBar;
    public double num1 = 0;
    public double num2 = 0;
    public String operator = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewDisplayBar = findViewById(R.id.TextViewDisplayBar);
    }

    public void addChar(View view) {
        if (
                !view.getTag().toString().equals("+") &&
                !view.getTag().toString().equals("-") &&
                !view.getTag().toString().equals("*") &&
                !view.getTag().toString().equals("/")
        ) {
            textViewDisplayBar.setText(textViewDisplayBar.getText().toString() + view.getTag().toString());
        } else {
            operator = view.getTag().toString();
            num1 = Double.parseDouble(textViewDisplayBar.getText().toString());
            textViewDisplayBar.setText("");
        }
    }

    public void clear(View view) {
        textViewDisplayBar.setText("");
    }

    public void calculate(View view) {
        num2 = Double.parseDouble(textViewDisplayBar.getText().toString());
        double result = num1;
        switch (operator) {
            case "+": {
                result += num2;
                textViewDisplayBar.setText(Double.toString(result));
                break;
            }
            case "-": {
                result -= num2;
                textViewDisplayBar.setText(Double.toString(result));
                break;
            }
            case "*": {
                result *= num2;
                textViewDisplayBar.setText(Double.toString(result));
                break;
            }
            case "/": {
                result /= num2;
                textViewDisplayBar.setText(Double.toString(result));
                break;
            }
        }
    }

    public void closeMe(View view) {
        Toast.makeText(this, "Goodbye! Have a nice one :)", Toast.LENGTH_SHORT).show();
        finish();
    }
}