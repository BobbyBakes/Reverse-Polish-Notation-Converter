package com.bobbybaker.app.infix;

import java.util.Stack;

import static com.bobbybaker.app.infix.ConversionHelper.isOperator;
import static com.bobbybaker.app.infix.ConversionHelper.addParenthesis;
import static com.bobbybaker.app.infix.ConversionHelper.placeOperatorBetweenTopTwoObjectsOfStack;


/**
 * Created by bobbybaker on 10/24/16.
 */
class RPNTools {

    public static String convert(String RPN) {
        String[] RPNArray = RPN.split("");
        int indexOfLastCharacter = RPNArray.length - 1;
        Stack<String> equationStack = new Stack<String>();

        for (int positionInEquation = 0; positionInEquation < RPNArray.length; positionInEquation++) {
            String operandOrOperator = String.valueOf(RPN.charAt(positionInEquation));
            handleOperatorAndOperands(indexOfLastCharacter, equationStack, positionInEquation, operandOrOperator);
        }
        return equationStack.peek();
    }

    private static void handleOperatorAndOperands(int indexOfLastCharacter, Stack<String> equationStack, int i, String operandOrOperator) {
        if (isOperator(operandOrOperator)) {
            determineOperatorPlacementAndAddToStack(equationStack, operandOrOperator, shouldAddParenthesis(i, indexOfLastCharacter));
        } else {
            equationStack.add(operandOrOperator);
        }
    }

    private static boolean shouldAddParenthesis(int i, int indexOfLastCharacter) {
        return i != indexOfLastCharacter;
    }

    private static void determineOperatorPlacementAndAddToStack(Stack<String> equationStack, String operator, boolean shouldAddParenthesis) {
        StringBuilder newNotation = new StringBuilder();
        int insertOperatorAtPosition = equationStack.peek().length();

        placeOperatorBetweenTopTwoObjectsOfStack(equationStack, operator, newNotation, insertOperatorAtPosition);
        if (shouldAddParenthesis) {
            addParenthesis(newNotation);
        }
        equationStack.add(newNotation.toString());
    }
}
