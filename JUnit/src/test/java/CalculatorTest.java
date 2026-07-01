import org.ashutosh.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setting up test........ ");
        calculator = new Calculator();
    }

    @Test
    public void addsTwoNumbers() {
        // Arrange
        int a = 10;
        int b = 20;
        // Act
        int result = calculator.add(a, b);
        // Assert
        assertEquals(30, result);
    }

    @Test
    public void subtractsTwoNumbers() {
        // Arrange
        int a = 10;
        int b = 20;
        // Act
        int result = calculator.subtract(2, 3);
        // Assert
        assertEquals(-1, result);

    }
    @Test
    public void multiplyTwoNumbers() {
        // Arrange
        int a = 10;
        int b = 20;
        // Act
        int result = calculator.multiply(2, 3);
        // Assert
        assertEquals(6, result);

    }
    @Test
    public void dividesTwoNumbers() {
        // Arrange
        int a = 10;
        int b = 20;
        // Act
        int result = calculator.divide(5, 5);
        // Assert
        assertEquals(1, result);

    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up........ ");
        calculator = null;
    }

}
