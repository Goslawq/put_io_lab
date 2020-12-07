package put.io.testing.audiobooks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {

    AudiobookPriceCalculator calculator = null;
    Customer customer = null;
    Audiobook audiobook = null;

    @BeforeEach
    void setUp() {
        calculator = new AudiobookPriceCalculator();
        audiobook = new Audiobook("Free Audible Original", 100);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_Subscribed_calculate() {
        customer = new Customer("Jasiek", Customer.LoyaltyLevel.STANDARD, true);
        assertEquals(0.0, calculator.calculate(customer, audiobook));
    }

    @Test
    void test_Silver_calculate() {
        customer = new Customer("Jasiek", Customer.LoyaltyLevel.SILVER, false);
        assertEquals(90.0, calculator.calculate(customer, audiobook));
    }

    @Test
    void test_Gold_calculate() {
        customer = new Customer("Jasiek", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(80.0, calculator.calculate(customer, audiobook));
    }

    @Test
    void test_Standard_calculate() {
        customer = new Customer("Jasiek", Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(100.0, calculator.calculate(customer, audiobook));
    }
}