package com.bobbybaker.app.infix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTest {

    @Test
    public void ifCharacterIsPlusOperator() {
        String operator= "+";
        String nonOperator= "b";
        {
            assertEquals(true, InfixTools.isOperator(operator));
            assertEquals(false, InfixTools.isOperator(nonOperator));
        }
    }

    @Test
    public void convertInfixToRPNWithAddition() {
        String parenthesisInfix = "a+b";
        {
            assertEquals("ab+", InfixTools.convertAddition(parenthesisInfix));
        }
    }
}
