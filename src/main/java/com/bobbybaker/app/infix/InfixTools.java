package com.bobbybaker.app.infix;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTools {
    public InfixTools(){

    }
    public static boolean containsAddition(String additionInfix) {
        return additionInfix.contains("+");
    }

    public static boolean containsExponent(String exponentInfix) {
        return exponentInfix.contains("^");
    }

    public static boolean containsDivision(String divisionInfix) {
        return divisionInfix.contains("/");
    }

    public static boolean containsMultiplication(String multiplicationInfix) {
        return multiplicationInfix.contains("*");
    }
}
