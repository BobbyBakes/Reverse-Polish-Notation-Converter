package com.bobbybaker.app.infix;

import java.util.Stack;

/**
 * Created by bobbybaker on 10/24/16.
 */
public class RPNTools {
    private static final String OPERATORS = "^/*-+";
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";

    public static boolean isOperator(String operator) {
        return OPERATORS.contains(operator);
    }

    public static String convert(String RPN) {
        int indexOfLastCharacter = RPN.length() - 1;
        String[] RPNArray = RPN.split("");
        Stack<String> equationStack = new Stack<String>();
        for (int i = 0; i < RPNArray.length; i++) {
            String operandOrOperator = String.valueOf(RPN.charAt(i));
            if (isOperator(operandOrOperator)) {
                determineOperatorPlacementAndAddToStack(equationStack, operandOrOperator, shouldAddParenthesis(i, indexOfLastCharacter));
            } else {
                equationStack.add(operandOrOperator);
            }

        }
        return equationStack.pop();
    }

    private static boolean shouldAddParenthesis(int i, int indexOfLastCharacter) {
        return i != indexOfLastCharacter;
    }

    private static void determineOperatorPlacementAndAddToStack(Stack<String> equationStack, String t, boolean addParenthesis) {
        StringBuilder newNotation = new StringBuilder();
        int insertOperatorAtPosition = equationStack.peek().length();
        newNotation.insert(newNotation.length(), equationStack.pop());
        newNotation.insert(0, equationStack.pop());
        newNotation.insert(newNotation.length() - insertOperatorAtPosition, t);
        if (addParenthesis) {
            newNotation.insert(0, LEFT_PARENTHESIS);
            newNotation.insert(newNotation.length(), RIGHT_PARENTHESIS);
        }
        equationStack.add(newNotation.toString());
    }
}
