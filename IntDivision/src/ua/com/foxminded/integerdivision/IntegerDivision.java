package ua.com.foxminded.integerdivision;

public class IntegerDivision {

    private static final int START_REPLACE_ZERO = 0;
    private static final int START_REPLACE_ONE = 1;
    private static final int IF_DIGIT_DIVIDEND_IS_ZERO = 0;
    private static final int POSITION_DETERMINATION_ONE = 1;
    private static final int POSITION_DETERMINATION_TWO = 2;
    private static final int INDEX_THREE_DIVISION_STRINGS = 3;
    private static final int INDEX_STRING_DIVIDEND_AND_DIVIDER = 0;
    private static final int INDEX_STRING_LINES_FOR_QOUTIENT = 1;
    private static final int INDEX_STRING_VALUE_QUOTIENT = 2;
    private static final String NEW_STRING = "\n";
    private static final String VERTICAL_LINE = "|";
    private static final String DIVISION = " / ";
    private static final String EQUAL_ZERO = " = 0";
    private static final String EQUAL_ONE = " = 1";
    private static final String LOWER_HORIZONTAL_LINE = "_";
    private static final String SPACE_STRING = " ";
    private static final char HORIZONTAL_LINE = '-';
    private static final char SPACE_CHAR = ' ';
    private static final char EQUAL_WITH_NEW_STRING = '\n';

    public String divide(int dividend, int divider) {

        if ((dividend < 0) || (divider < 0)) {
            throw new ArithmeticException("Dividend or divider can't be negative numbers!");
        } else if (dividend < divider) {
            return dividend + DIVISION + divider + EQUAL_ZERO;
        } else if ((dividend == 0) && (divider == 0)) {
            return dividend + DIVISION + divider + EQUAL_ZERO;
        } else if (dividend == divider) {
            return dividend + DIVISION + divider + EQUAL_ONE;
        } else if (dividend == 0) {
            return dividend + DIVISION + divider + EQUAL_ZERO;
        } else if (divider == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return divisionProcess(dividend, divider);
    }

    private String divisionProcess(int dividend, int divider) {

        StringBuilder result = new StringBuilder();
        StringBuilder quotient = new StringBuilder();
        StringBuilder remainder = new StringBuilder();

        Integer dividerDigit = getVerticalLineCoefficient(divider);
        String[] digits = String.valueOf(dividend).split("");
        for (int i = 0; i < digits.length; i++) {
            remainder.append(digits[i]);
            Integer remainderOfTheNumber = Integer.parseInt(remainder.toString());

            if (remainderOfTheNumber >= divider) {
                Integer module = remainderOfTheNumber % divider;
                Integer multiplyResult = remainderOfTheNumber / divider * divider;

                String lastRemainder = String.format("%" + (i + POSITION_DETERMINATION_TWO) + "s",
                        LOWER_HORIZONTAL_LINE + remainderOfTheNumber.toString());
                result.append(lastRemainder).append(NEW_STRING);

                String multiply = String.format("%" + (i + POSITION_DETERMINATION_TWO) + "d", multiplyResult);
                result.append(multiply).append(NEW_STRING);

                Integer tab = lastRemainder.length() - getVerticalLineCoefficient(multiplyResult);
                result.append(makeDivider(remainderOfTheNumber, tab)).append(NEW_STRING);

                quotient.append(remainderOfTheNumber / divider);

                remainder.replace(START_REPLACE_ZERO, remainder.length(), module.toString());
                remainderOfTheNumber = Integer.parseInt(remainder.toString());
            } else if (i >= dividerDigit) {
                quotient.append(IF_DIGIT_DIVIDEND_IS_ZERO);
            }

            if (i == digits.length - 1) {
                result.append(
                        String.format("%" + (i + POSITION_DETERMINATION_TWO) + "s", remainderOfTheNumber.toString()))
                        .append(NEW_STRING);
            }

        }
        getThreeStringsDvision(dividend, divider, quotient, result);
        return result.toString();
    }

    private String makeDivider(Integer remainderOfTheNumber, Integer tab) {
        return getLinesAboveQoutient(tab, SPACE_CHAR)
                + getLinesAboveQoutient(getVerticalLineCoefficient(remainderOfTheNumber), HORIZONTAL_LINE);
    }

    private StringBuilder getThreeStringsDvision(Integer dividend, Integer divisor, StringBuilder quotient,
            StringBuilder result) {

        int[] index = new int[INDEX_THREE_DIVISION_STRINGS];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == EQUAL_WITH_NEW_STRING) {
                index[j] = i;
                j++;
            }

            if (j == INDEX_THREE_DIVISION_STRINGS) {
                break;
            }
        }

        int tab = getVerticalLineCoefficient(dividend) + POSITION_DETERMINATION_ONE
                - index[INDEX_STRING_DIVIDEND_AND_DIVIDER];

        result.insert(index[INDEX_STRING_VALUE_QUOTIENT],
                getLinesAboveQoutient(tab, SPACE_CHAR) + VERTICAL_LINE + quotient.toString());
        result.insert(index[INDEX_STRING_LINES_FOR_QOUTIENT], getLinesAboveQoutient(tab, SPACE_CHAR) + VERTICAL_LINE
                + getLinesAboveQoutient(quotient.length(), HORIZONTAL_LINE));
        result.insert(index[INDEX_STRING_DIVIDEND_AND_DIVIDER], VERTICAL_LINE + SPACE_STRING + divisor);
        result.replace(START_REPLACE_ONE, index[INDEX_STRING_DIVIDEND_AND_DIVIDER], dividend.toString());
        return result;
    }

    private int getVerticalLineCoefficient(int i) {
        return (int) Math.log10(i) + POSITION_DETERMINATION_ONE;
    }

    private String getLinesAboveQoutient(int numberOfSymbols, char symbol) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < numberOfSymbols; i++) {
            string.append(symbol);
        }
        return string.toString();
    }

}

