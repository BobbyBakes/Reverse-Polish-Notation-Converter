package com.bobbybaker.app.infix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTest {

    private InfixTools infixTools;


    @Before
    public void setUp() {
        infixTools = new InfixTools();
    }

    @Test
    public void ifInfixContainsAddition() {
        String additionInfix = "a+b";
        String nonAdditionInfix = "a-b";
        {
            assertEquals(true, infixTools.containsAddition(additionInfix));
            assertEquals(false, infixTools.containsAddition(nonAdditionInfix));
        }
    }

    @Test
    public void ifInfixContainsExponent() {
        String exponentInfix = "a^b";
        String nonExponentInfix = "a-b";
        {
            assertEquals(true, infixTools.containsExponent(exponentInfix));
            assertEquals(false, infixTools.containsExponent(nonExponentInfix));
        }
    }

}
