package com.bobbybaker.app.infix;

/**
 * Created by bobbybaker on 10/24/16.
 */
public class RPNTools {
    private static final String operators = "^/*-+";
    public static boolean isOperator(String operator) {
        return operators.contains(operator);
    }
}
