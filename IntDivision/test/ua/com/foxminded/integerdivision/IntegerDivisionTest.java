package ua.com.foxminded.integerdivision;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

class IntegerDivisionTest {

    @Rule
    IntegerDivision tester = new IntegerDivision();

    @Test
    void returnArithmeticExceptionBecauseDividerIsZero() {
        assertThrows(ArithmeticException.class, () -> new IntegerDivision().divide(78945, 0));
    }

    @Test
    void returnArithmeticExceptionBecauseDividendIsNegativeNumber() {
        assertThrows(ArithmeticException.class, () -> new IntegerDivision().divide(-78945, 4));
    }

    @Test
    void returnArithmeticExceptionBecauseDividerIsNegativeNumber() {
        assertThrows(ArithmeticException.class, () -> new IntegerDivision().divide(78945, -4));
    }

    @Test
    void returnZeroWhenDividendAndDividerAreZero() {
        assertEquals("0 / 0 = 0", tester.divide(0, 0));
    }

    @Test
    void returnZeroWhenDividendAreZero() {
        assertEquals("0 / 78945 = 0", tester.divide(0, 78945));
    }

    @Test
    void returnZeroWhenDividendIsLessThanDivider() {
        assertEquals("78944 / 78945 = 0", tester.divide(78944, 78945));
    }

    @Test
    void returnOneWhenDividendAndDividerAreEqual() {
        assertEquals("78945 / 78945 = 1", tester.divide(78945, 78945));
    }

    @Test
    void outputDivisionResultWhenAbsentRemainder() {
       assertEquals("_78945| 5\n"
                  + " 5    |-----\n"
                  + " -    |15789\n"
                  + "_28\n"
                  + " 25\n"
                  + " --\n"
                  + " _39\n"
                  + "  35\n"
                  + "  --\n"
                  + "  _44\n"
                  + "   40\n"
                  + "   --\n"
                  + "   _45\n"
                  + "    45\n"
                  + "    --\n"
                  + "     0\n", tester.divide(78945, 5));
    }

    @Test
    void outputDivisionResultWhenIsRemainder() {
       assertEquals("_78945| 4\n"
                  + " 4    |-----\n"
                  + " -    |19736\n"
                  + "_38\n"
                  + " 36\n"
                  + " --\n"
                  + " _29\n"
                  + "  28\n"
                  + "  --\n"
                  + "  _14\n"
                  + "   12\n"
                  + "   --\n"
                  + "   _25\n"
                  + "    24\n"
                  + "    --\n"
                  + "     1\n", tester.divide(78945, 4));
    }
    
    @Test
    void divisionResultWhenUsingLimitInt() {
       assertEquals("_2147483647| 1\n"
                  + " 2         |----------\n"
                  + " -         |2147483647\n"
                  + " _1\n"
                  + "  1\n"
                  + "  -\n"
                  + "  _4\n"
                  + "   4\n"
                  + "   -\n"
                  + "   _7\n"
                  + "    7\n"
                  + "    -\n"
                  + "    _4\n"
                  + "     4\n"
                  + "     -\n"
                  + "     _8\n"
                  + "      8\n"
                  + "      -\n"
                  + "      _3\n"
                  + "       3\n"
                  + "       -\n"
                  + "       _6\n"
                  + "        6\n"
                  + "        -\n"
                  + "        _4\n"
                  + "         4\n"
                  + "         -\n"
                  + "         _7\n"
                  + "          7\n"
                  + "          -\n"
                  + "          0\n", tester.divide(2147483647, 1));
    }
    
}

