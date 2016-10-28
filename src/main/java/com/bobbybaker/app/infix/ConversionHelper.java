package com.bobbybaker.app.infix;

import java.util.Stack;

import static com.bobbybaker.app.infix.Constants.OPERATORS;
import static com.bobbybaker.app.infix.Constants.PARENTHESIS;
import static com.bobbybaker.app.infix.Constants.LEFT_PARENTHESIS;
import static com.bobbybaker.app.infix.Constants.RIGHT_PARENTHESIS;

/**
 * Created by bobbybaker on 10/28/16.
 */
public class ConversionHelper {

    static boolean isOperator(String operator) {
        return OPERATORS.contains(operator);
    }

    static boolean operatorIsParenthesis(String operator) {
        return PARENTHESIS.contains(operator);
    }


    static void addParenthesis(StringBuilder newNotation) {
        newNotation.insert(0, LEFT_PARENTHESIS);
        newNotation.insert(newNotation.length(), RIGHT_PARENTHESIS);
    }

    static void placeOperatorBetweenTopTwoObjectsOfStack(Stack<String> equationStack, String operator, StringBuilder newNotation, int insertOperatorAtPosition) {
        newNotation.insert(newNotation.length(), equationStack.pop());
        newNotation.insert(0, equationStack.pop());
        newNotation.insert(newNotation.length() - insertOperatorAtPosition, operator);
    }

    static boolean operatorAtTopOfStackIsIdentical(Stack<String> operatorStack, String operator) {
        return !(operatorStack.isEmpty() || !(operatorStack.peek().equals(operator)));
    }

    static void emptyStackAndAppendToResult(StringBuilder result, Stack<String> operatorStack) {
        while (!operatorStack.isEmpty()) {
            result.append(operatorStack.pop());
        }
    }

    static void pushLeftParenthesisOntoStack(Stack<String> stack, String parenthesis) {
        if (parenthesis.equals(LEFT_PARENTHESIS)) {
            stack.push(parenthesis);
        }
    }

    static boolean operatorAtTopOfStackHasPrecedence(Stack<String> operatorStack, String operator) {
        return !(operatorStack.isEmpty() || operatorIsParenthesis(operatorStack.peek()) || !stackOperatorHasPrecedence(operatorStack, operator));
    }

    private static boolean stackOperatorHasPrecedence(Stack<String> operatorStack, String operator) {
        return OPERATORS.indexOf(operatorStack.peek()) < OPERATORS.indexOf(operator);
    }
}
