package com.bobbybaker.app.infix;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTools {
    public InfixTools() {

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

    public static boolean containsSubtraction(String subtractionInfix) {
        return subtractionInfix.contains("-");
    }

    public static boolean containsParenthesis(String parenthesisInfix) {
        return parenthesisInfix.contains("(") && parenthesisInfix.contains(")");
    }

    public static String convertAddition(String parenthesisInfix) {
        StringBuilder sb = new StringBuilder(parenthesisInfix);
        if (containsAddition(parenthesisInfix)) {
            int plusIndex = parenthesisInfix.indexOf("+");
            sb.deleteCharAt(plusIndex);
            sb.append("+");
        }
        return sb.toString();
    }
}
