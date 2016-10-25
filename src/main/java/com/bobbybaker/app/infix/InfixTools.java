package com.bobbybaker.app.infix;

import java.util.Stack;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTools {
    //    Order of operations string represents correct presidence of each operation
    private static final String operators = "^/*-+()";

    public InfixTools() {
    }

    public static boolean isOperator(String operator) {
        return operators.contains(operator);
    }

    public static String convert(String additionInfix) {
        String[] additionInfixArray = additionInfix.split("");
        StringBuilder result = new StringBuilder();
        Stack<String> operatorStack = new Stack<String>();
        for (String t : additionInfixArray) {
            if (!isOperator(t)) {
                result.append(t);
            } else {
                int operatorIndex = operators.indexOf(t);
                switch (operatorIndex) {
                    // ^
                    case 0:
                        reStack(result, operatorStack, t);
                        operatorStack.push(t);
                        break;
                    // \/
                    case 1:
                        reStack(result, operatorStack, t);
                        operatorStack.push(t);
                        break;
                    // *
                    case 2:
                        reStack(result, operatorStack, t);
                        operatorStack.push(t);
                        break;
                    // -
                    case 3:
                        reStack(result, operatorStack, t);
                        operatorStack.push(t);
                        break;
                    // +
                    case 4:
                        reStack(result, operatorStack, t);
                        operatorStack.push(t);
                        break;
                    // +
                    case 5:
                        reStack(result, operatorStack, t);
                        operatorStack.push(t);
                        break;
                    // +
                    case 6:
                        while (operatorStack.contains("(")) {
                            String operator = operatorStack.pop();
                            if (operator.equals("(")) {
                                break;
                            }
                            result.append(operator);
                        }
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            result.append(operatorStack.pop());
        }
        return result.toString();
    }

    private static void reStack(StringBuilder result, Stack<String> operatorStack, String t) {
        if (!operatorStack.isEmpty()) {
            while (hasPrecedence(operatorStack, t)) {
                result.append(operatorStack.pop());
            }
        }
    }

    public static boolean hasPrecedence(Stack<String> operatorStack, String operator) {
        if (!operatorStack.isEmpty()) {
            if (operators.indexOf(operatorStack.peek()) < operators.indexOf(operator)) {
                return true;
            }
        }
        return false;
    }
}
