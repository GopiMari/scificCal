package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView Display;
    boolean dotexists = false;
    float num1 = 0.0f;
    float num2 = 0.0f;
    float total = 0.0f;
    String opused = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display = (TextView) findViewById(R.id.edisplay);
    }

    public void numfield(View view) {

        Button clicked = (Button) view;
        Display.append(clicked.getText());
    }


    public void operator(View view) {

        if (Display.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "No value entered", Toast.LENGTH_SHORT).show();
            return;
        }


        num1 = Float.parseFloat(Display.getText().toString());
        Display.setHint(Display.getText().toString());
        Display.setText(null);
        opused = ((Button) view).getText().toString();
        Toast.makeText(getApplicationContext(), opused, Toast.LENGTH_SHORT).show();

    }

    public void clearfield(View view) {

        Display.setText(null);
        Display.setHint("0.000");
        dotexists = false;
    }

    public void dotfield(View view) {

        if (dotexists == false) {
            if (Display.getText().length() == 0) {
                Display.append("0");
            }
            Display.append(".");
            dotexists = true;
        }

    }

    public void Equalfield(View view) {


        if (Display.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "No Value is entered ", Toast.LENGTH_SHORT).show();
            return;
        }

        num2 = Float.parseFloat(Display.getText().toString());

        Log.i("testtt", num1+"   "+num2);

        switch (opused) {
            case "+":
                total = num1 + num2;
                break;

            case "-":
                total = num1 - num2;
                break;
            case "*":
                total = num1 * num2;
                break;
            case "/":
                total = num1 / num2;
                break;
            default:
                Toast.makeText(getApplicationContext(), "You need to select an operation ", Toast.LENGTH_SHORT).show();


        }
        Display.setText((String.valueOf(total)));
        Toast.makeText(this, "Total :" + total, Toast.LENGTH_SHORT).show();

    }
}
