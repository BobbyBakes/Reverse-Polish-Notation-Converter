package com.bobbybaker.app.infix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTest {

    @Test
    public void ifCharacterIsAdditionOperator() {
        String operator = "+";
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(operator));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsExponentOperator() {
        String operator = "^";
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(operator));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsDivisionOperator() {
        String operator = "/";
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(operator));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsMultiplicationOperator() {
        String operator = "*";
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(operator));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsSubtractionOperator() {
        String operator = "-";
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(operator));
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
        String parenthesisInfix = "a-b";
        {
            assertEquals("ab-", InfixTools.convert(parenthesisInfix));
        }
    }

    @Test
    public void convertInfixToRPNWithAdditionAndSubtraction() {
        String parenthesisInfix = "a+b-c";
        {
            assertEquals("abc-+", InfixTools.convert(parenthesisInfix));
        }
    }
}
