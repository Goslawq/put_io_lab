package put.io.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

public class FailureOrErrorTest {
    @Test
    void test1(){
        assertTrue(false);
    }

    @Test
    void test2(){
        int x = 1/0;
    }

    @Test
    void test3(){
        try{
            assertTrue(false);
        }catch(AssertionFailedError e){
            e.printStackTrace();
        }
    }
}
