package com.example.benbenian.simplecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivityOld extends AppCompatActivity {
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
        showOnDebug();
        if (!mainDisplay.isEmpty() && Double.isNaN(valueOne)) { //Fresh start
            valueOne = Double.parseDouble(mainDisplay);
            topDisplay = topDisplay + "sqr(" + decimalFormat.format(valueOne) + ")";
            valueOne *= valueOne;
            showOnTopDisplay(topDisplay);
            showOnMainDisplay(decimalFormat.format(valueOne));
            mainDisplay = "";
        } else if (mainDisplay.isEmpty() && !Double.isNaN(valueOne)) {  //Some stored value, no new input
            /*switch (currentOp) { //check the currentOp
                case "Plus":
                    topDisplay = topDisplay + "+";
                    break;
                case "Minus":
                    topDisplay = topDisplay + "-";
                    break;
                case "Mult":
                    topDisplay = topDisplay + "x";
                    break;
                case "Div":
                    topDisplay = topDisplay + "÷";
                    break;
            }*/
            //topDisplay = topDisplay + "sqr(" + decimalFormat.format(valueOne) + ")"; //put sqr() around old value

            //showOnTopDisplay(topDisplay);
            //showOnMainDisplay(decimalFormat.format(valueOne * valueOne));
            mainDisplay = decimalFormat.format(valueOne * valueOne);  //use mainDisplay as the sqaured value

            /*valueTwo = Double.parseDouble(mainDisplay);
            mainDisplay = "";
            showOnMainDisplay(mainDisplay);
            switch (currentOp) {
                case "Plus":
                    valueOne += valueTwo;
                    showOnMainDisplay(decimalFormat.format(valueOne));
                    break;
                case "Minus":
                    valueOne -= valueTwo;
                    showOnMainDisplay(decimalFormat.format(valueOne));
                    break;
                case "Mult":
                    valueOne *= valueTwo;
                    showOnMainDisplay(decimalFormat.format(valueOne));
                    break;
                case "Div":
                    valueOne /= valueTwo;
                    showOnMainDisplay(decimalFormat.format(valueOne));
                    break;
            }*/

            compute();
            currentOp = "Square";


        } else if (!mainDisplay.isEmpty() && !Double.isNaN(valueOne)) {  //Some stored value, new input

        }
        showOnDebug();
        //compute();

    }

    public void opInv(View view) {
    }

    public void opCE(View view) {
        mainDisplay = "";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }

    public void opC(View view) {
        mainDisplay = "";
        showOnMainDisplay(mainDisplay);
        topDisplay = "";
        showOnTopDisplay(topDisplay);
        valueOne = Double.NaN;
        currentOp = "";
        showOnDebug();
    }

    public void opBack(View view) {
        if (!mainDisplay.equals("")) {
            mainDisplay = mainDisplay.substring(0, mainDisplay.length() - 1);
        }
        showOnMainDisplay(mainDisplay);
        showOnDebug();
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
        showOnDebug();
    }

    public void opPoint(View view) {
        mainDisplay += ".";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }

    public void opEq(View view) {
        compute();
        valueOne = Double.NaN;
        currentOp = "";
        topDisplay = "";
        showOnTopDisplay(topDisplay);
        mainDisplay = "";
        showOnDebug();
    }

    public void opPlus(View view) {
        if (!mainDisplay.equals("")) compute();
        if (!topDisplay.equals("")) showOnTopDisplay(topDisplay + "+");
        currentOp = "Plus";
        showOnDebug();
    }

    public void opMinus(View view) {
        if (!mainDisplay.equals("")) compute();
        if (!topDisplay.equals("")) showOnTopDisplay(topDisplay + "-");
        currentOp = "Minus";
        showOnDebug();
    }

    public void opMult(View view) {
        if (!mainDisplay.equals("")) compute();
        if (!topDisplay.equals("")) showOnTopDisplay(topDisplay + "x");
        currentOp = "Mult";
        showOnDebug();
    }

    public void opDiv(View view) {
        if (!mainDisplay.equals("")) compute();
        if (!topDisplay.equals("")) showOnTopDisplay(topDisplay + "÷");
        currentOp = "Div";
        showOnDebug();
    }

    /* Number Buttons*/
    public void num0(View view) {
        mainDisplay += "0";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }

    public void num1(View view) {
        mainDisplay += "1";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }

    public void num2(View view) {

        mainDisplay += "2";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }

    public void num3(View view) {
        mainDisplay += "3";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }

    public void num4(View view) {
        mainDisplay += "4";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }

    public void num5(View view) {
        mainDisplay += "5";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }

    public void num6(View view) {
        mainDisplay += "6";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }

    public void num7(View view) {
        mainDisplay += "7";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }

    public void num8(View view) {
        mainDisplay += "8";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }

    public void num9(View view) {
        mainDisplay += "9";
        showOnMainDisplay(mainDisplay);
        showOnDebug();
    }


}
