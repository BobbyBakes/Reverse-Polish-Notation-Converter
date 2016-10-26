package com.bobbybaker.app.infix;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by bobbybaker on 10/24/16.
 */
public class RPNTools {
    private static final String OPERATORS = "^/*-+";

    public static boolean isOperator(String operator) {
        return OPERATORS.contains(operator);
    }

    public static String convert(String RPN) {
        String[] RPNArray = RPN.split("");
        StringBuilder result = new StringBuilder();
        Stack<String> operatorQueue = new Stack();
        for (String t : RPNArray) {
            if (isOperator(t)) {
                operatorQueue.add(t);
                determineOperatorPlacement(operatorQueue, result);
//                placeOperator(t, result, operatorQueue);
            } else {
                result.append(t);
            }

        }
        return result.toString();
    }


    private static void determineOperatorPlacement(Stack<String> operatorQueue, StringBuilder result) {
        if (!operatorQueue.isEmpty()) {
            String operator = operatorQueue.pop();
            result.insert(result.length() - 1, operator);
            char a = result.charAt(result.length() - 3);
            if (a != ')') {
                result.insert(result.length() - 3, "(");
                result.insert(result.length(), ")");
            }
        }
    }

    private static void placeOperator(String t, StringBuilder result, Queue<String> operandQueue) {
        result.insert(result.length() - 1, t);
    }
}
