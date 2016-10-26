package com.bobbybaker.app.infix;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class RPNTest {
    private static final String EXPONENT = "^";
    private static final String DIVISION = "/";
    private static final String MULTIPLICATION = "*";
    private static final String SUBTRACTION = "-";
    private static final String ADDITION = "+";

    @Test
    public void ifCharacterIsAdditionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, RPNTools.isOperator(ADDITION));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsExponentOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, RPNTools.isOperator(EXPONENT));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsDivisionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, RPNTools.isOperator(DIVISION));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsMultiplicationOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, RPNTools.isOperator(MULTIPLICATION));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsSubtractionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, RPNTools.isOperator(SUBTRACTION));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void convertRPNToInfixWithAddition() {
        String infix = "ab+";
        {
            assertEquals("a+b", RPNTools.convert(infix));
        }
    }

    @Test
    public void convertRPNToInfixWithSubtraction() {
        String infix = "ab-";
        {
            assertEquals("a-b", RPNTools.convert(infix));
        }
    }

    @Test
    public void convertRPNToInfixExpectingParenthesis() {
        String infix = "ab+c-";
        {
            assertEquals("(a+b)-c", RPNTools.convert(infix));
        }
    }

    @Test
    public void convertRPNToInfixWithMultipleOperators() {
        String infix = "ag+ba-c+cedf^*+^*";
        {
            assertEquals("(a+g)*(((b-a)+c)^(c+(e*(d^f))))", RPNTools.convert(infix));
        }
    }

}
