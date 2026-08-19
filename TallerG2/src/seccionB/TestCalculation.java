package seccionB;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestCalculation {


    @Test
    public void testFindMaxPositivos() {

        assertEquals(4,Calculation.findMax(new int[]{1, 3, 4, 2})
                );
            
    }


    @Test
    public void testFindMaxNegativos() {

        assertEquals(
            -1,
            Calculation.findMax(new int[]{-12, -1, -3, -4, -2})
        );
    }


    @Test
    public void testFindMaxPositivosYNegativos() {

        assertEquals(
            10,
            Calculation.findMax(new int[]{-5, 3, -8, 10, 2})
        );
    }
}