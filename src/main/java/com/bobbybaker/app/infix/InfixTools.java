package com.bobbybaker.app.infix;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTools {
    public InfixTools(){

    }
    public boolean containsAddition(String additionInfix) {
        return additionInfix.contains("+");
    }

    public boolean containsExponent(String exponentInfix) {
        return exponentInfix.contains("^");
    }

    public boolean containsDivision(String divisionInfix) {
        return divisionInfix.contains("/");
    }

    public boolean containsMultiplication(String multiplicationInfix) {
        return multiplicationInfix.contains("*");
    }
}
