package com.bobbybaker.app.infix;

import org.junit.Test;


import static com.bobbybaker.app.infix.Constants.*;
import static com.bobbybaker.app.infix.ConversionHelper.isOperator;
import static org.junit.Assert.assertEquals;

/**
 * Created by bobbybaker on 10/23/16.
 */
public class RPNTest {


    @Test
    public void convertRPNToInfixWithAddition() {
        String infix = "ab+";
        {
            assertEquals("a+b", RPNTools.convert(infix));
        }
    }

    @Test
    public void convertRPNToInfixWithSubtraction() {
        String infix = "ab-";
        {
            assertEquals("a-b", RPNTools.convert(infix));
        }
    }

    @Test
    public void convertRPNToInfixExpectingParenthesis() {
        String infix = "ab+c-";
        {
            assertEquals("(a+b)-c", RPNTools.convert(infix));
        }
    }

    @Test
    public void convertRPNToInfixWithMultipleOperators() {
        String infix = "ag+ba-c+cedf^*+^*";
        {
            assertEquals("(a+g)*(((b-a)+c)^(c+(e*(d^f))))", RPNTools.convert(infix));
        }
    }

}
