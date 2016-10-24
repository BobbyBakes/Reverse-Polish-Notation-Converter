package com.bobbybaker.app.infix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class InfixTest {

    @Test
    public void ifInfixContainsAddition() {
        String additionInfix = "a+b";
        String nonAdditionInfix = "a-b";
        {
            assertEquals(true, InfixTools.containsAddition(additionInfix));
            assertEquals(false, InfixTools.containsAddition(nonAdditionInfix));
        }
    }

    @Test
    public void ifInfixContainsExponent() {
        String exponentInfix = "a^b";
        String nonExponentInfix = "a-b";
        {
            assertEquals(true, InfixTools.containsExponent(exponentInfix));
            assertEquals(false, InfixTools.containsExponent(nonExponentInfix));
        }
    }

    @Test
    public void ifInfixContainsDivision() {
        String divisionInfix = "a/b";
        String nonDivisionInfix = "a-b";
        {
            assertEquals(true, InfixTools.containsDivision(divisionInfix));
            assertEquals(false, InfixTools.containsDivision(nonDivisionInfix));
        }
    }

    @Test
    public void ifInfixContainsMultiplication() {
        String multiplicationInfix = "a*b";
        String nonMultiplicationInfix = "a-b";
        {
            assertEquals(true, InfixTools.containsMultiplication(multiplicationInfix));
            assertEquals(false, InfixTools.containsMultiplication(nonMultiplicationInfix));
        }
    }

    @Test
    public void ifInfixContainsSubtraction() {
        String subtractionInfix = "a-b";
        String nonSubstractionInfix = "a*b";
        {
            assertEquals(true, InfixTools.containsSubtraction(subtractionInfix));
            assertEquals(false, InfixTools.containsSubtraction(nonSubstractionInfix));
        }
    }

    @Test
    public void ifInfixContainsParenthesis() {
        String parenthesisInfix = "(a+b)-c";
        String nonParenthesisInfix = "a+b-c";
        {
            assertEquals(true, InfixTools.containsParenthesis(parenthesisInfix));
            assertEquals(false, InfixTools.containsParenthesis(nonParenthesisInfix));
        }
    }
}
