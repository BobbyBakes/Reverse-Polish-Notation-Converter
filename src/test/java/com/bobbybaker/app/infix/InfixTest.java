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
    public void ifIfixContainsAddition() {
        String additionInfix = "a+b";
        String nonAdditionInfix = "a-b";
        {
            assertEquals(true, infixTools.containsAddition(additionInfix));
            assertEquals(false, infixTools.containsAddition(nonAdditionInfix));
        }
    }

}
