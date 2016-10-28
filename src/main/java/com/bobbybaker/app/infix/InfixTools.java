package com.bobbybaker.app.infix;

import java.util.Stack;

import static com.bobbybaker.app.infix.Constants.*;
import static com.bobbybaker.app.infix.ConversionHelper.*;

/**
 * Strategy:
 * Each character in the equation is read.
 * Operands are written to a string representing the result.
 * In the instance of an operator, operators are pushed to a stack.
 * In the case that the next operator being pushed to the stack has lower precedence than the operator at the top of the stack, then the stack is emptied until the operator remaining in the stack has lower precedence.
 * The operator in question is then pushed to the stack.
 * Once the end of the equation is reached, the remaining stack is written to the end of the resulting string, representing an equation in RPN.
 */
public class InfixTools {

    public static String convert(String infix) {
        String[] infixArray = infix.split("");

        StringBuilder result = new StringBuilder();
        Stack<String> operatorStack = new Stack<String>();

        for (String operandOrOperator : infixArray) {
            handleOperandAndOperators(result, operandOrOperator, operatorStack);
        }

        emptyStackAndAppendToResult(result, operatorStack);

        return result.toString();
    }

    private static void handleOperandAndOperators(StringBuilder result, String operandOrOperator, Stack<String> operatorStack) {
        if (isOperator(operandOrOperator)) {
            appendOperatorsThatHavePrecedenceOrEqualPrecedenceToResult(result, operatorStack, operandOrOperator);
            operatorStack.push(operandOrOperator);
        } else if (operatorIsParenthesis(operandOrOperator)) {
            pushLeftParenthesisOntoStack(operatorStack, operandOrOperator);
            appendOperatorWithinParenthesis(result, operatorStack, operandOrOperator);
            // Else an operand
        } else {
            result.append(operandOrOperator);
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

    private static void appendOperatorsThatHavePrecedenceOrEqualPrecedenceToResult(StringBuilder result, Stack<String> operatorStack, String operator) {
        if (!operatorStack.isEmpty()) {
            while (operatorAtTopOfStackHasPrecedence(operatorStack, operator) || operatorAtTopOfStackIsIdentical(operatorStack, operator)) {
                result.append(operatorStack.pop());
            }
        }
    }
}
