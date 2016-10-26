package com.bobbybaker.app.infix;

import java.util.Stack;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTools {
    //    Order of operations string represents correct precedence of each operation
    private static final String OPERATORS = "^/*-+";
    private static final String PARENTHESIS = "()";

    public InfixTools() {
    }

    public static boolean isOperator(String operator) {
        return OPERATORS.contains(operator);
    }

    public static boolean isParenthesis(String operator) {
        return PARENTHESIS.contains(operator);
    }

    public static String convert(String additionInfix) {
        String[] additionInfixArray = additionInfix.split("");
        StringBuilder result = new StringBuilder();
        Stack<String> operatorStack = new Stack<String>();
        for (String t : additionInfixArray) {
            if (isOperator(t)) {
                appendPrecedenceAndIdenticalOperators(result, operatorStack, t);
                operatorStack.push(t);
            } else if (isParenthesis(t)) {
                if (t.equals(")")) {
                    while (operatorStack.contains("(")) {
                        String operator = operatorStack.pop();
                        if (operator.equals("(")) {
                            break;
                        }
                        result.append(operator);
                    }
                }
                if (t.equals("(")) {
                    {
                        operatorStack.push(t);
                    }
                }
            } else {
                result.append(t);
            }


        }
        while (!operatorStack.isEmpty()) {
            result.append(operatorStack.pop());
        }
        return result.toString();
    }

    private static boolean identicalToTopOfStack(Stack<String> operatorStack, String t) {
        if (operatorStack.isEmpty() || !(operatorStack.peek().equals(t))) {
            return false;
        }
        return true;
    }

    private static void appendPrecedenceAndIdenticalOperators(StringBuilder result, Stack<String> operatorStack, String t) {
        if (!operatorStack.isEmpty()) {
            while (operatorAtTopOfStackHasPrecedence(operatorStack, t) || identicalToTopOfStack(operatorStack,t)) {
                result.append(operatorStack.pop());
            }
        }
    }

    public static boolean operatorAtTopOfStackHasPrecedence(Stack<String> operatorStack, String operator) {
        if (operatorStack.isEmpty() || isParenthesis(operatorStack.peek()) || !(OPERATORS.indexOf(operatorStack.peek()) < OPERATORS.indexOf(operator))) {
            return false;
        }
        return true;
    }
}
