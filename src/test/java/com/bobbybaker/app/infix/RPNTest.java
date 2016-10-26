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
    private static final String exponent = "^";
    private static final String division = "/";
    private static final String multiplication = "*";
    private static final String subtraction = "-";
    private static final String addition = "+";
    private Queue<String> operandQueue;


    @Before
    public void setUp() {
       operandQueue = new LinkedList();
    }

    @Test
    public void ifCharacterIsAdditionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, RPNTools.isOperator(addition));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsExponentOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, RPNTools.isOperator(exponent));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsDivisionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, RPNTools.isOperator(division));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsMultiplicationOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, RPNTools.isOperator(multiplication));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void ifCharacterIsSubtractionOperator() {
        String nonOperator = "b";
        {
            assertEquals(true, RPNTools.isOperator(subtraction));
            assertEquals(false, RPNTools.isOperator(nonOperator));
        }
    }

    @Test
    public void convertRPNToInfixWithAddition() {
        String parenthesisInfix = "ab+";
        {
            assertEquals("a+b", RPNTools.convert(parenthesisInfix));
        }
    }
}
