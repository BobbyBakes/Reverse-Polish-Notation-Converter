package com.bobbybaker.app.infix;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTools {
    private static final String operators = "^/*-+";
    public InfixTools() {
    }

    public static boolean isOperator(String operator) {
        return operators.contains(operator);
    }

    public static String convertAddition(String additionInfix) {
        String[] additionInfixArray = additionInfix.split("");
        StringBuilder sb = new StringBuilder(additionInfix);
        for (String t : additionInfixArray) {
            if (isOperator(t)) {
                int plusIndex = additionInfix.indexOf("+");
                sb.deleteCharAt(plusIndex);
                sb.append("+");
            }
        }
        return sb.toString();
    }
}
