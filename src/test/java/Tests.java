import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator",
                0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator",
                1, standard.getDenominator());
    }

    @Test
    public void testGetConstructor() {
        int numerator = 1;
        int denominator = 2;

        Rational rational = new Rational(numerator,denominator);
        assertEquals("getNumerator returns wrong numerator",
                numerator, rational.getNumerator());
        assertEquals("getDenominator returns wrong denominator",
                denominator, rational.getDenominator());
    }

    @Test
    public void testSetConstructor() {
        int numerator = 1;
        int denominator = 2;

        Rational rational = new Rational();
        rational.setNumerator(numerator);
        rational.setDenominator(denominator);
        assertEquals("setNumerator sets wrong numerator",
                numerator, rational.getNumerator());
        assertEquals("setDenominator sets wrong denominator",
                denominator, rational.getDenominator());
    }

    @Test(expected = ArithmeticException.class)
    public void testWrongRationalConstruction(){
        Rational wrongRational = new Rational(1, 0);
        fail("testWrongRationalConstruction() failed. " +
                "\n There's no arithmeticException when denominator is 0. ");
    }

    @Test
    public void testPositiveRational() {
        int numerator = 1;
        int denominator = 2;
        String expectedResult = "1/2";

        String rational = new Rational(numerator,denominator).toString();
        assertEquals("toString returns wrong string value for positive rational",
                expectedResult, rational);
    }

    @Test
    public void testNegativeNumerator() {
        int numerator = -1;
        int denominator = 2;
        String expectedResult = "-1/2";

        String rational = new Rational(numerator,denominator).toString();
        assertEquals("toString returns wrong string value for negative numerator",
                expectedResult, rational);
    }

    @Test
    public void testNegativeDenominator() {
        int numerator = 1;
        int denominator = -2;
        String expectedResult = "-1/2";

        String rational = new Rational(numerator,denominator).toString();
        assertEquals("toString returns wrong string value for negative denominator",
                expectedResult, rational);
    }

    @Test
    public void testNegativeNumeratorAndDenominator() {
        int numerator = -1;
        int denominator = -2;
        String expectedResult = "1/2";

        String rational = new Rational(numerator,denominator).toString();
        assertEquals("toString returns wrong string value for negative numerator and denominator",
                expectedResult, rational);
    }

    @Test
    public void testReduction() {
        int numerator = 100;
        int denominator = 15;
        String expectedResult = "20/3";

        String rational = new Rational(numerator,denominator).toString();
        assertEquals("toString returns wrong string value when reduce",
                expectedResult, rational);
    }

    @Test
    public void testReductionWhithZeroNumerator() {
        int numerator = 0;
        int denominator = -15;
        String expectedResult = "0/1";

        String rational = new Rational(numerator,denominator).toString();
        assertEquals("toString returns wrong string value when numerator = 0. ",
                expectedResult, rational);
    }

    @Test
    public void testEquals(){
        Rational firstRational = new Rational(1, 2);
        Rational secondRational = new Rational(1, 2);

        assertTrue("Wrong equals override", firstRational.equals(secondRational));
    }

    @Test
    public void testNotEquals(){
        Rational firstRational = new Rational(1, 2);
        Rational secondRational = new Rational(2, 1);

        assertFalse("Wrong equals override", firstRational.equals(secondRational));
    }

    @Test
    public void testNotEqualsObjects(){
        Rational rational = new Rational();
        String string = "0/1";

        assertFalse("Not equals objects", rational.equals(string));
    }

    @Test
    public void testIsLess(){
        Rational firstRational = new Rational(1, 2);
        Rational secondRational = new Rational(2, 1);

        assertTrue("Method less returns wrong boolean value for: " +
                        firstRational + " < " + secondRational,
                firstRational.less(secondRational));
    }

    @Test
    public void testIsMoreNotLess(){
        Rational firstRational = new Rational(3, 1);
        Rational secondRational = new Rational(3, 2);

        assertFalse("Method less returns wrong boolean value for: "
                        + firstRational + " > " + secondRational,
                firstRational.less(secondRational));
    }

    @Test
    public void testIsEqualNotLess(){
        Rational firstRational = new Rational(1, 1);
        Rational secondRational = new Rational(1, 1);

        assertFalse("Method less returns wrong boolean value for: "
                        + firstRational + " = " + secondRational,
                firstRational.less(secondRational));
    }

    @Test
    public void testIsLessForNegativeRational(){
        Rational firstRational = new Rational(1, -2);
        Rational secondRational = new Rational(2, 4);

        assertTrue("Method less returns wrong boolean value for: "
                        + firstRational + " < " + secondRational,
                firstRational.less(secondRational));
    }

    @Test
    public void testIsLessForZeroRational(){
        Rational firstRational = new Rational(0, 1);
        Rational secondRational = new Rational(1, 3);

        assertTrue("Method less returns wrong boolean value for: "
                        + firstRational + " < " + secondRational,
                firstRational.less(secondRational));
    }

    @Test
    public void testLessForLessOrEqual(){
        Rational firstRational = new Rational(0, 1);
        Rational secondRational = new Rational(1, 3);

        assertTrue("Method lessOrEqual returns wrong boolean value for: "
                        + firstRational + " <= " + secondRational,
                firstRational.lessOrEqual(secondRational));
    }

    @Test
    public void testEqualForLessOrEqual(){
        Rational firstRational = new Rational(0, 1);
        Rational secondRational = new Rational(0, 3);

        assertTrue("Method lessOrEqual returns wrong boolean value for: "
                        + firstRational + " <= " + secondRational,
                firstRational.lessOrEqual(secondRational));
    }

    @Test
    public void testMoreForLessOrEqual(){
        Rational firstRational = new Rational(10, 1);
        Rational secondRational = new Rational(1, 3);

        assertFalse("Method lessOrEqual returns wrong boolean value for: "
                        + firstRational + " > " + secondRational,
                firstRational.less(secondRational));
    }

    @Test
    public void testAdditionRational(){
        Rational firstRational = new Rational(10, 1);
        Rational secondRational = new Rational(1, 3);
        Rational expectedSum = new Rational(31, 3);

        assertEquals("The addition of two Rationals is wrong",
                expectedSum,firstRational.plus(secondRational));
    }

    @Test
    public void testMultiplicationRational(){
        Rational firstRational = new Rational(10, 1);
        Rational secondRational = new Rational(1, 3);
        Rational expectedSum = new Rational(10, 3);

        assertEquals("The multiplication of two Rationals is wrong",
                expectedSum,firstRational.multiply(secondRational));
    }

    @Test
    public void testSubtractionRational(){
        Rational firstRational = new Rational(10, 1);
        Rational secondRational = new Rational(1, 3);
        Rational expectedSum = new Rational(29, 3);

        assertEquals("The subtraction of two Rationals is wrong",
                expectedSum,firstRational.minus(secondRational));
    }

    @Test
    public void testDivisionRational(){
        Rational firstRational = new Rational(10, 1);
        Rational secondRational = new Rational(1, 3);
        Rational expectedSum = new Rational(30, 1);

        assertEquals("The division of two Rationals is wrong",
                expectedSum,firstRational.divide(secondRational));
    }

    @Test(expected = ArithmeticException.class)
    public void testDevisionByZero(){
        Rational firstRational = new Rational(1, 2);
        Rational secondRational = new Rational(0, 1);

        firstRational.divide(secondRational);
        fail("testDevisionByZero() failed. " +
                "\n There's no arithmeticException when devision by zero.");
    }
}