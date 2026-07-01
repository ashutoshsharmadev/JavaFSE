import org.ashutosh.Calculator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    @Test
    public void addsTwoNumbers() {
//            Calculator calculator = new Calculator();

        int result = calculator.add(2, 3);

        assertEquals(5, result);
    }

    @Test
    public void subtractsTwoNumbers() {

        int result = calculator.subtract(2, 3);

        assertEquals(-1, result);

    }
    @Test
    public void multiplyTwoNumbers() {

        int result = calculator.multiply(2, 3);

        assertEquals(6, result);

    }
    @Test
    public void dividesTwoNumbers() {

        int result = calculator.divide(5, 5);

        assertEquals(1, result);

    }
}
