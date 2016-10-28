package com.bobbybaker.app.infix;

import java.util.Stack;

import static com.bobbybaker.app.infix.ConversionHelper.isOperator;
import static com.bobbybaker.app.infix.ConversionHelper.addParenthesis;
import static com.bobbybaker.app.infix.ConversionHelper.placeOperatorBetweenTopTwoObjectsOfStack;


/**
 * Strategy:
 * Each character in the equation is read.
 * Operands are pushed to a stack.
 * Once a operator is read, the top two objects in the stack are popped.
 * The operator is then placed between those two string objects and surrounded by parenthesis.
 * The resulting string is then pushed back to the stack and the next character is read.
 * Once another operator is read, the top two are popped off the stack and the operator is placed between the two objects and surrounded by parenthesis.
 * This is repeated until the end of the equation.
 * The remaining string left in the stack is returned in a peek, representing a string an equation in RPN.
 */
public class RPNTools {

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
