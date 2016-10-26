package com.bobbybaker.app.infix;

import java.util.LinkedList;
import java.util.Queue;

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
        Queue<String> operandQueue = new LinkedList();

        for (String t : RPNArray) {
            if (isOperator(t)) {
                placeOperator(t, result, operandQueue);
            } else {
                operandQueue.add(t);
            }
        }
        return result.toString();
    }

    private static void placeOperator(String t, StringBuilder result, Queue<String> operandQueue) {
        result.append(operandQueue.remove());
        result.append(t);
        result.append(operandQueue.remove());
    }


}
