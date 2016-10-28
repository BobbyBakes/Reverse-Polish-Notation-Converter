package com.bobbybaker.app.infix;

import java.util.Stack;

import static com.bobbybaker.app.infix.Constants.*;
import static com.bobbybaker.app.infix.ConversionHelper.isOperator;
import static com.bobbybaker.app.infix.ConversionHelper.operatorIsParenthesis;
import static com.bobbybaker.app.infix.ConversionHelper.stackOperatorHasPrecedence;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTools {

    public static String convert(String infix) {
        String[] infixArray = infix.split("");

        StringBuilder result = new StringBuilder();
        Stack<String> operatorStack = new Stack<String>();

        for (String operandOrOperator : infixArray) {
            if (isOperator(operandOrOperator)) {
                appendOperatorsThatHavePrecedenceOrEqualPrecedenceToResult(result, operatorStack, operandOrOperator);
                operatorStack.push(operandOrOperator);
            } else if (operatorIsParenthesis(operandOrOperator)) {
                pushLeftParenthesisOntoStack(operatorStack, operandOrOperator);
                appendOperatorWithinParenthesis(result, operatorStack, operandOrOperator);
            } else {
                result.append(operandOrOperator);
            }
        }

        emptyOperatorStackAndAppendToResult(result, operatorStack);

        return result.toString();
    }


    private static void pushLeftParenthesisOntoStack(Stack<String> operatorStack, String parenthesis) {
        if (parenthesis.equals(LEFT_PARENTHESIS)) {
            operatorStack.push(parenthesis);
        }
    }

    private static void appendOperatorWithinParenthesis(StringBuilder result, Stack<String> operatorStack, String parenthesis) {
        if (parenthesis.equals(RIGHT_PARENTHESIS)) {
            while (operatorStack.contains(LEFT_PARENTHESIS)) {
                String operator = operatorStack.pop();
                if (operator.equals(LEFT_PARENTHESIS)) {
                    break;
                }
                result.append(operator);
            }
        }
    }

    private static void emptyOperatorStackAndAppendToResult(StringBuilder result, Stack<String> operatorStack) {
        while (!operatorStack.isEmpty()) {
            result.append(operatorStack.pop());
        }
    }


    private static void appendOperatorsThatHavePrecedenceOrEqualPrecedenceToResult(StringBuilder result, Stack<String> operatorStack, String operator) {
        if (!operatorStack.isEmpty()) {
            while (operatorAtTopOfStackHasPrecedence(operatorStack, operator) || operatorAtTopOfStackIsIdentical(operatorStack, operator)) {
                result.append(operatorStack.pop());
            }
        }
    }

    static boolean operatorAtTopOfStackHasPrecedence(Stack<String> operatorStack, String operator) {
        return !(operatorStack.isEmpty() || operatorIsParenthesis(operatorStack.peek()) || !stackOperatorHasPrecedence(operatorStack, operator));
    }

    private static boolean operatorAtTopOfStackIsIdentical(Stack<String> operatorStack, String operator) {
        return !(operatorStack.isEmpty() || !(operatorStack.peek().equals(operator)));
    }

}
