package com.bobbybaker.app.infix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class RPNTest {

    @Test
    public void ifCharacterIsAdditionOperator() {
        String operator= "+";
        String nonOperator= "b";
        {
            assertEquals(true, RPNTools.isOperator(operator));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }
@Test
    public void ifCharacterIsExponentOperator() {
        String operator= "^";
        String nonOperator= "b";
        {
            assertEquals(true, RPNTools.isOperator(operator));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsDivisionOperator() {
        String operator= "/";
        String nonOperator= "b";
        {
            assertEquals(true, RPNTools.isOperator(operator));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsMultiplicationOperator() {
        String operator= "*";
        String nonOperator= "b";
        {
            assertEquals(true, RPNTools.isOperator(operator));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsSubtractionOperator() {
        String operator= "-";
        String nonOperator= "b";
        {
            assertEquals(true, RPNTools.isOperator(operator));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }
}
