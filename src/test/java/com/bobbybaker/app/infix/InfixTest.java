package com.bobbybaker.app.infix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTest {
    private static final String exponent = "^";
    private static final String division = "/";
    private static final String multiplication = "*";
    private static final String subtraction = "-";
    private static final String addition = "+";


    @Test
    public void ifCharacterIsAdditionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(addition));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsExponentOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(exponent));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsDivisionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(division));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsMultiplicationOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(multiplication));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsSubtractionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(subtraction));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void convertInfixToRPNWithAddition() {
        String parenthesisInfix = "a+b";
        {
            assertEquals("ab+", InfixTools.convert(parenthesisInfix));
        }
    }

    @Test
    public void convertInfixToRPNWithSubtraction() {
        String infix = "a-b";
        {
            assertEquals("ab-", InfixTools.convert(infix));
        }
    }

    @Test
    public void convertInfixToRPNWithAdditionAndSubtraction() {
        String infix = "a+b-c";
        {
            assertEquals("abc-+", InfixTools.convert(infix));
        }
    }

    @Test
    public void convertInfixToRPNWithAdditionAndSubtractionWithParenthesis() {
        String infix = "(a+b)-c";
        {
            assertEquals("ab+c-", InfixTools.convert(infix));
        }
    }

    @Test
    public void ifOperatorHasPrecedence() {
        {
            assertTrue(InfixTools.hasPrecedence(exponent, addition));
            assertTrue(InfixTools.hasPrecedence(division, addition));
            assertTrue(InfixTools.hasPrecedence(multiplication, addition));
            assertTrue(InfixTools.hasPrecedence(division, subtraction));
        }
    }


}
