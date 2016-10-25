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
        Stack<String> operatorStack = new Stack();
        for (String t : additionInfixArray) {
            if (!isOperator(t)) {
                result.append(t);
            } else {
                int operatorIndex = operators.indexOf(t);
                switch (operatorIndex) {
                    // ^
                    case 0:
                        operatorStack.push(t);
                        break;
                    // \/
                    case 1:
                        operatorStack.push(t);
                        break;
                    // *
                    case 2:
                        operatorStack.push(t);
                        break;
                    // -
                    case 3:
                        operatorStack.push(t);
                        break;
                    // +
                    case 4:
                        operatorStack.push(t);
                        break;
                    // +
                    case 5:
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

    public static boolean hasPrecedence(String operator1, String operator2) {
        if (operators.indexOf(operator1)< operators.indexOf(operator2)){
            return true;
        }
        return false;
    }
}
