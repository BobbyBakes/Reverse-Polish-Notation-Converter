package com.bobbybaker.app.infix;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static com.bobbybaker.app.infix.Constants.*;
import static com.bobbybaker.app.infix.ConversionHelper.isOperator;
import static com.bobbybaker.app.infix.ConversionHelper.operatorAtTopOfStackHasPrecedence;
import static com.bobbybaker.app.infix.ConversionHelper.operatorIsParenthesis;
import static org.junit.Assert.assertEquals;

/**
 * Created by bobbybaker on 10/28/16.
 */
public class ConversionHelperTest {
    private Stack stack;

    @Before
    public void setUp() {
        stack = new Stack();
    }

    @Test
    public void ifCharacterIsAdditionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, isOperator(ADDITION));
            assertEquals(false, isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsExponentOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, isOperator(EXPONENT));
            assertEquals(false, isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsDivisionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, isOperator(DIVISION));
            assertEquals(false, isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsMultiplicationOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, isOperator(MULTIPLICATION));
            assertEquals(false, isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsSubtractionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, isOperator(SUBTRACTION));
            assertEquals(false, isOperator(nonOperator));
        }
    }

    @Test
    public void ifTopOfStackHasPrecedenceOverOperator() {
        stack.push(ADDITION);
        stack.push(MULTIPLICATION);
        assertEquals(true, operatorAtTopOfStackHasPrecedence(stack, ADDITION));
        assertEquals(true, operatorAtTopOfStackHasPrecedence(stack, SUBTRACTION));
        assertEquals(false, operatorAtTopOfStackHasPrecedence(stack, MULTIPLICATION));
        assertEquals(false, operatorAtTopOfStackHasPrecedence(stack, DIVISION));
        assertEquals(false, operatorAtTopOfStackHasPrecedence(stack, EXPONENT));
    }

    @Test
    public void ifOperatorIsParenthesis() {
        String nonParenthesis= "+";
        {
            assertEquals(true, operatorIsParenthesis(PARENTHESIS));
            assertEquals(false, operatorIsParenthesis(nonParenthesis));
        }
    }
}
