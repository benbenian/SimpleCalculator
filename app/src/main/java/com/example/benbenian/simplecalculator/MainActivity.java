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

    /* Compute */
    public void compute() {
        try {

            if (!Double.isNaN(valueOne)) {

                valueTwo = Double.parseDouble(mainDisplay);
                mainDisplay = "";
                showOnMainDisplay(mainDisplay);


                switch (currentOp) {
                    case "Percent":
                        break;
                    case "Sqroot":
                        break;
                    case "Square":

                        break;
                    case "Inv":
                        break;
                    case "Eq":
                        showOnMainDisplay(decimalFormat.format(valueOne));
                        break;
                    case "Plus":
                        valueOne += valueTwo;
                        showOnMainDisplay(decimalFormat.format(valueOne));
                        topDisplay = topDisplay + "+" + decimalFormat.format(valueTwo);
                        showOnTopDisplay(topDisplay);
                        break;
                    case "Minus":
                        valueOne -= valueTwo;
                        showOnMainDisplay(decimalFormat.format(valueOne));
                        topDisplay = topDisplay + "-" + decimalFormat.format(valueTwo);
                        showOnTopDisplay(topDisplay);

                        break;
                    case "Mult":
                        valueOne *= valueTwo;
                        showOnMainDisplay(decimalFormat.format(valueOne));
                        topDisplay = topDisplay + "x" + decimalFormat.format(valueTwo);
                        showOnTopDisplay(topDisplay);

                        break;
                    case "Div":
                        valueOne /= valueTwo;
                        showOnMainDisplay(decimalFormat.format(valueOne));
                        topDisplay = topDisplay + "÷" + decimalFormat.format(valueTwo);
                        showOnTopDisplay(topDisplay);

                        break;
                }
            } else {
                valueOne = Double.parseDouble(mainDisplay);
                topDisplay = decimalFormat.format(valueOne);
                showOnTopDisplay(topDisplay);
                mainDisplay = "";
            }

        } catch (Exception e) {
        }
    }


    /* Operations Buttons*/
    public void opPercent(View view) {
    }

    public void opSqroot(View view) {
    }

    public void opSquare(View view) {
        if (!mainDisplay.isEmpty() && Double.isNaN(valueOne)) {
            valueOne = Double.parseDouble(mainDisplay);
            topDisplay = topDisplay + "sqr(" + decimalFormat.format(valueOne) + ")";
            valueOne *= valueOne;
            showOnTopDisplay(topDisplay);
            showOnMainDisplay(decimalFormat.format(valueOne));
            mainDisplay = "";
        }
        else if (mainDisplay.isEmpty() && !Double.isNaN(valueOne)) {
            valueOne *= valueOne;
            showOnMainDisplay(decimalFormat.format(valueOne));
            //mainDisplay = decimalFormat.format(valueOne);
            //compute();
        }

        //compute();

    }

    public void opInv(View view) {
    }

    public void opCE(View view) {
        mainDisplay = "";
        showOnMainDisplay(mainDisplay);
    }

    public void opC(View view) {
        mainDisplay = "";
        showOnMainDisplay(mainDisplay);
        topDisplay = "";
        showOnTopDisplay(topDisplay);
        valueOne = Double.NaN;
        currentOp = "";
    }

    public void opBack(View view) {
        if (!mainDisplay.equals("")) {
            mainDisplay = mainDisplay.substring(0, mainDisplay.length() - 1);
        }
        showOnMainDisplay(mainDisplay);
    }

    public void opPlusMinus(View view) {
        if (!mainDisplay.isEmpty()) {
            if (mainDisplay.charAt(0) == '-')
                mainDisplay = mainDisplay.substring(1, mainDisplay.length());
            else if (Character.isDigit(mainDisplay.charAt(0)))
                mainDisplay = "-" + mainDisplay;
            showOnMainDisplay(mainDisplay);
        } else if (!Double.isNaN(valueOne)) {
            showOnMainDisplay(decimalFormat.format(0 - valueOne));
            mainDisplay = decimalFormat.format(0 - valueOne);
        }
    }

    public void opPoint(View view) {
        mainDisplay += ".";
        showOnMainDisplay(mainDisplay);
    }

    public void opEq(View view) {
        compute();
        valueOne = Double.NaN;
        currentOp = "";
        topDisplay = "";
        showOnTopDisplay(topDisplay);
        mainDisplay = "";
    }

    public void opPlus(View view) {
        if (!mainDisplay.equals("")) compute();
        if (!topDisplay.equals("")) showOnTopDisplay(topDisplay + "+");
        currentOp = "Plus";
    }

    public void opMinus(View view) {
        if (!mainDisplay.equals("")) compute();
        if (!topDisplay.equals("")) showOnTopDisplay(topDisplay + "-");
        currentOp = "Minus";
    }

    public void opMult(View view) {
        if (!mainDisplay.equals("")) compute();
        if (!topDisplay.equals("")) showOnTopDisplay(topDisplay + "x");
        currentOp = "Mult";
    }

    public void opDiv(View view) {
        if (!mainDisplay.equals("")) compute();
        if (!topDisplay.equals("")) showOnTopDisplay(topDisplay + "÷");
        currentOp = "Div";
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
