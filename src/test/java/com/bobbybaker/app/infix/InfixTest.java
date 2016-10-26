package com.bobbybaker.app.infix;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTest {
    private static final String EXPONENT = "^";
    private static final String DIVISION = "/";
    private static final String MULTIPLICATION = "*";
    private static final String SUBTRACTION = "-";
    private static final String ADDITION = "+";
    private Stack<String> stack;

    @Before
    public void setUp() {
        stack = new Stack();
    }


    @Test
    public void ifCharacterIsAdditionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(ADDITION));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsExponentOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(EXPONENT));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsDivisionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(DIVISION));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsMultiplicationOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(MULTIPLICATION));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsSubtractionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, InfixTools.isOperator(SUBTRACTION));
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
    public void ifTopOfStackHasPrecedenceOverOperator() {
        {
            stack.push(ADDITION);
            stack.push(MULTIPLICATION);
            assertEquals(true, InfixTools.operatorAtTopOfStackHasPrecedence(stack, ADDITION));
            assertEquals(true, InfixTools.operatorAtTopOfStackHasPrecedence(stack, SUBTRACTION));
            assertEquals(false, InfixTools.operatorAtTopOfStackHasPrecedence(stack, MULTIPLICATION));
            assertEquals(false, InfixTools.operatorAtTopOfStackHasPrecedence(stack, DIVISION));
            assertEquals(false, InfixTools.operatorAtTopOfStackHasPrecedence(stack, EXPONENT));
        }
    }

    @Test
    public void convertInfixToRPNWithMultipleOperators() {
        {
            String infix = "l/m^n*o-p";
            {
                assertEquals("lmn^/o*p-", InfixTools.convert(infix));
            }
        }
    }

    @Test
    public void convertInfixToRPNWithMultipleOperatorsWithParenthesis() {
        {
            String infix = "((l/(m^n))*o)-p";
            {
                assertEquals("lmn^/o*p-", InfixTools.convert(infix));
            }
        }
    }

    @Test
    public void convertInfixToRPNWithMultipleIdenticalOperators() {
        {
            String infix = "a^b^c";
            {
                assertEquals("ab^c^", InfixTools.convert(infix));
            }
        }
    }

    @Test
    public void convertInfixToRPNWithComplexEquation() {
        {
            String infix = "(a+g)*(((b-a)+c)^(c+(e*(d^f))))";
            {
                assertEquals("ag+ba-c+cedf^*+^*", InfixTools.convert(infix));
            }
        }
    }

}
