package com.bobbybaker.app.infix;

import java.util.Stack;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTools {
    //    Order of operations string represents correct presidence of each operation
    private static final String operators = "^/*-+";

    public InfixTools() {
    }

    public static boolean isOperator(String operator) {
        return operators.contains(operator);
    }

    public static String convert(String additionInfix) {
        String[] additionInfixArray = additionInfix.split("");
        StringBuilder result = new StringBuilder();
        Stack <String> operandStack = new Stack();
        for (String t : additionInfixArray) {
            if (!isOperator(t)) {
                result.append(t);
            } else {
                int operatorIndex = operators.indexOf(t);
                switch (operatorIndex) {
                        // ^
                    case 0:
                        operandStack.push(t);
                        break;
                        // \/
                    case 1:
                        operandStack.push(t);
                        break;
                        // *
                    case 2:
                        operandStack.push(t);
                        break;
                        // -
                    case 3:
                        operandStack.push(t);
                        break;
                        // +
                    case 4:
                        operandStack.push(t);
                        break;
                }
            }
        }
        while(!operandStack.isEmpty()){
           result.append(operandStack.pop());
        }
        return result.toString();
    }
}
