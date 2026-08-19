package seccionB;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestCalculation {
	
	@Test
    public void findMaxPositiveArray() {
		assertEquals(67, Calculation.findMax(new int[]{14, 67, 7, 6, 15}));
    }

    @Test
    public void findMaxNegativeArray() {
    	assertEquals(-5, Calculation.findMax(new int[]{-13, -8, -5, -29, -38}));
    }

    @Test
    public void findMaxMixedArray() {
    	assertEquals(25, Calculation.findMax(new int[]{-10, 2, 17, -9, -18, 3, 25}));
    }
}
