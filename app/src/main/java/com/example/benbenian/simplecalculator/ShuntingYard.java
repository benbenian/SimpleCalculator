package com.example.benbenian.simplecalculator;

import java.util.Stack;

/**
 * Created by benben on 1/23/2018.
 */

public class ShuntingYard {


    static int precLevel(char op) { //PrecedenceLevel
        switch (op) {
            case '+':
            case '-':
                return 0;
            case 'x':
            case '÷':
                return 1;
            case '√':
            case '²':
                return 2;
        }
        return -1;
    }

    static String convertToPostfix(String in) {
        /*  Operator Stack Symbol:
            - = 0
            + = 1
            ÷ = 2
            x = 3
            √ = 4
            ² = 5
        */
        final String opPre = "-+÷x√²";

        Stack<Integer> s = new Stack<>();   //Operator Stack
        StringBuilder sb = new StringBuilder(); //Output String

        for (String token : in.split("\\s")) {
            if (token.isEmpty()) continue;
            char c = token.charAt(0);
            int idx = opPre.indexOf(c);

            if (idx != -1) {
                if (s.isEmpty()) s.push(idx);    //Operator Stack Empty
                else {                          //Operator Stack Not Empty
                    while (!s.isEmpty()) {
                        int prec2 = precLevel(opPre.charAt(s.peek()));
                        int prec1 = precLevel(c);
                        if (prec2 > prec1 || (prec2 == prec1))
                            sb.append(opPre.charAt(s.pop())).append(' ');
                        else break;
                    }
                    s.push(idx);
                }
            } else if (c == '(') {
                s.push(-2); //-2 stands for '('
            } else if (c == ')') {
                while (s.peek() != -2)
                    sb.append(opPre.charAt(s.pop())).append(' ');
                s.pop();
            } else sb.append(token).append(' ');
        }
        while (!s.isEmpty()) sb.append(opPre.charAt(s.pop())).append(' ');
        return sb.toString();

    }

    static Double evalPostfix(String in) {
        Stack<Double> s = new Stack<>();
        final String opPre = "-+÷x√²";

        //DecimalFormat df = new DecimalFormat();

        for (String token : in.split("\\s") ) {
            if (token.isEmpty()) continue;

            char c = token.charAt(0);
            int idx = opPre.indexOf(c);
            if (idx != -1) {   //token is Operator
                if (s.isEmpty()) return Double.NaN; //Error
                else {
                    Double x1;
                    Double x2;
                    Double eva;
                    switch (idx) {
                        case 0:
                            x2 = s.pop();
                            x1 = s.pop();
                            eva = x1-x2;
                            s.push(eva);
                            break;
                        case 1:
                            x2 = s.pop();
                            x1 = s.pop();
                            eva=x1+x2;
                            s.push(eva);
                            break;
                        case 2:
                            x2 = s.pop();
                            x1 = s.pop();
                            eva=x1/x2;
                            s.push(eva);
                            break;
                        case 3:
                            x2 = s.pop();
                            x1 = s.pop();
                            eva=x1*x2;
                            s.push(eva);
                            break;
                        case 4:   //SquareRoot Operator
                            break;
                        case 5:   //Square Operator
                            break;
                    }
                }
            } else {    //token is Operand
                s.push(Double.parseDouble(token));
            }
        }

        return(s.pop());
    }

}
