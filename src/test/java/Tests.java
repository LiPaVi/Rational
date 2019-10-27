import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Test
    public void testGetConstructor() {
        int numerator = 1;
        int denominator = 2;

        Rational rational = new Rational(numerator,denominator);
        assertEquals("getNumerator returns wrong numerator", numerator, rational.getNumerator());
        assertEquals("getDenominator returns wrong denominator", denominator, rational.getDenominator());
    }

    @Test
    public void testSetConstructor() {
        int numerator = 1;
        int denominator = 2;

        Rational rational = new Rational();
        rational.setNumerator(numerator);
        rational.setDenominator(denominator);
        assertEquals("setNumerator sets wrong numerator", numerator, rational.getNumerator());
        assertEquals("setDenominator sets wrong denominator", denominator, rational.getDenominator());
    }

    @Test
    public void testPositiveRational() {
        int numerator = 1;
        int denominator = 2;
        String expectedResult = "1/2";

        String positive = new Rational(numerator,denominator).toString();
        assertEquals("toString returns wrong string value for positive rational", expectedResult, positive);
    }

    @Test
    public void testNegativeNumerator() {
        int numerator = -1;
        int denominator = 2;
        String expectedResult = "-1/2";

        String positive = new Rational(numerator,denominator).toString();
        assertEquals("toString returns wrong string value for negative numerator", expectedResult, positive);
    }

    @Test
    public void testNegativeDenominator() {
        int numerator = 1;
        int denominator = -2;
        String expectedResult = "-1/2";

        String positive = new Rational(numerator,denominator).toString();
        assertEquals("toString returns wrong string value for negative denominator",  expectedResult, positive);
    }

    @Test
    public void testNegativeNumeratorAndDenominator() {
        int numerator = -1;
        int denominator = -2;
        String expectedResult = "1/2";

        String positive = new Rational(numerator,denominator).toString();
        assertEquals("toString returns wrong string value for negative numerator and denominator",  expectedResult, positive);
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
    public void testIsLess(){
        Rational firstRational = new Rational(1, 2);
        Rational secondRational = new Rational(2, 1);

        assertTrue("Method less returns wrong boolean value for: " +
                        firstRational + " < " + secondRational,
                firstRational.less(secondRational));
    }

    @Test
    public void testIsMoreNotLess(){
        Rational firstRational = new Rational(3, 2);
        Rational secondRational = new Rational(1, 2);

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
        Rational secondRational = new Rational(1, 3);

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

    @Test(expected = ArithmeticException.class)
    public void testDevisionByZero(){
        Rational firstRational = new Rational(1, 2);
        Rational secondRational = new Rational(0, 1);

        firstRational.divide(secondRational);
    }

}