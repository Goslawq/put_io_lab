package put.io.testing.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = null;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    // Mogłoby być BeforeAll bo Calculator jest bezstanowy

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    void test_correct_add() {
        assertEquals(12, calculator.add(5, 7));
    }

    @Test
    void test_incorrect_add() {
        assertNotEquals(14, calculator.add(5, 7));
    }

    @Test
    void test_correct_multiply() {
        assertEquals(25, calculator.multiply(5,5));
    }

    @Test
    void test_incorrect_multiply() {
        assertNotEquals(5, calculator.multiply(1,1));
    }

    @Test
    void test_IllegalArgumentException_addPositiveNumbers(){
        assertThrows(IllegalArgumentException.class, () ->{
            calculator.addPositiveNumbers(-5, 10);
        });
    }

    @Test
    void test_correct_addPositiveNumbers(){
        assertEquals(58, calculator.addPositiveNumbers(15,43));
    }
}
