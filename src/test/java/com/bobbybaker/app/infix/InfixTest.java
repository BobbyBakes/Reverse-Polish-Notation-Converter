package com.bobbybaker.app.infix;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTest {

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
