package com.example.benbenian.simplecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    String mainDisplay = "";
    String topDisplay = "";
    double valueOne = Double.NaN;
    double valueTwo;
    String currentOp = "";
    DecimalFormat decimalFormat = new DecimalFormat("#.########");
    String debugStr = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alternative);
        showOnMainDisplay(mainDisplay);
        showOnTopDisplay(topDisplay);
    }

    /*Display Methods*/
    public void showOnMainDisplay(String str) {
        TextView tv = findViewById(R.id.id_displayMain);
        tv.setText(str);
    }

    public void showOnTopDisplay(String str) {
        TextView tv = findViewById(R.id.id_displayTop);
        tv.setText(str);
    }

    public void showOnDebug() {
        String str;
        TextView tv = findViewById(R.id.degug);
        str = "mainDisplay: " + mainDisplay + "\n";
        str += "topDisplay: " + topDisplay + "\n";
        str += "valueOne: " + decimalFormat.format(valueOne) + "\n";
        str += "valueTwo: " + decimalFormat.format(valueTwo) + "\n";
        str += "currentOp: " + currentOp + "\n";

        tv.setText(str);
    }

    public double parseInput(String input) {
        String temp = "";
        double expr1 = 0;
        double ans;
        int bracket = 0, openBracket=0, closeBracket=0;



    return 0.0;
    }


    /* Operations Buttons*/
    public void opPercent(View view) {
        mainDisplay += "%";
        showOnMainDisplay(mainDisplay);
    }

    public void opSquare(View view) {
        mainDisplay += "²";
        showOnMainDisplay(mainDisplay);
    }

    public void opOpenBracket(View view) {
        mainDisplay += "(";
        showOnMainDisplay(mainDisplay);
    }

    public void opCloseBracket(View view) {
        mainDisplay += ")";
        showOnMainDisplay(mainDisplay);
    }

    public void opC(View view) {
        mainDisplay = "";
        showOnMainDisplay(mainDisplay);
    }

    public void opBack(View view) {
        if (!mainDisplay.isEmpty())
            mainDisplay = mainDisplay.substring(0, mainDisplay.length() - 1);
        showOnMainDisplay(mainDisplay);
    }

    public void opPoint(View view) {
        mainDisplay += ".";
        showOnMainDisplay(mainDisplay);
    }

    public void opEq(View view) {
        double ans = Double.NaN;
        ans = parseInput(mainDisplay);
        showOnMainDisplay(decimalFormat.format(ans));
    }

    public void opPlus(View view) {
        mainDisplay += "+";
        showOnMainDisplay(mainDisplay);
    }

    public void opMinus(View view) {
        mainDisplay += "-";
        showOnMainDisplay(mainDisplay);
    }

    public void opMult(View view) {
        mainDisplay += "x";
        showOnMainDisplay(mainDisplay);
    }

    public void opDiv(View view) {
        mainDisplay += "÷";
        showOnMainDisplay(mainDisplay);
    }

    /* Number Buttons*/
    public void num0(View view) {
        mainDisplay += "0";
        showOnMainDisplay(mainDisplay);
    }

    public void num1(View view) {
        mainDisplay += "1";
        showOnMainDisplay(mainDisplay);
    }

    public void num2(View view) {
        mainDisplay += "2";
        showOnMainDisplay(mainDisplay);
    }

    public void num3(View view) {
        mainDisplay += "3";
        showOnMainDisplay(mainDisplay);
    }

    public void num4(View view) {
        mainDisplay += "4";
        showOnMainDisplay(mainDisplay);
    }

    public void num5(View view) {
        mainDisplay += "5";
        showOnMainDisplay(mainDisplay);
    }

    public void num6(View view) {
        mainDisplay += "6";
        showOnMainDisplay(mainDisplay);
    }

    public void num7(View view) {
        mainDisplay += "7";
        showOnMainDisplay(mainDisplay);
    }

    public void num8(View view) {
        mainDisplay += "8";
        showOnMainDisplay(mainDisplay);
    }

    public void num9(View view) {
        mainDisplay += "9";
        showOnMainDisplay(mainDisplay);
    }


}
