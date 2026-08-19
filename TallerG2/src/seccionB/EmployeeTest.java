package seccionB;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    private Employee employee;

    @BeforeAll
    static void setUpClass() {
        System.out.println("=== INICIO DE LAS PRUEBAS ===");
    }

    @BeforeEach
    void setUp() {
        employee = null;
        System.out.println("Preparando prueba...");
    }

    @AfterEach
    void tearDown() {
        employee = null;
        System.out.println("Prueba finalizada.");
    }

    @AfterAll
    static void tearDownClass() {
        System.out.println("=== FIN DE LAS PRUEBAS ===");
    }

    @Test
    void testCalculateYearBonusWorker() {    	
        employee = new Employee( 1000F,"USD",10F,EmployeeType.Worker);                                              
        assertEquals(386F,employee.CalculateYearBonus(),0.001F);
                                              
    }

    @Test
    void testCalculateYearBonusSupervisor() {

        employee = new Employee(
                1000F,
                "USD",
                10F,
                EmployeeType.Supervisor
        );

        float expected = 1000F + (386F * 0.5F);

        assertEquals(
                expected,
                employee.CalculateYearBonus(),
                0.001F
        );
    }

    @Test
    void testCalculateYearBonusManager() {

        employee = new Employee(
                1000F,
                "USD",
                10F,
                EmployeeType.Manager
        );

        float expected = 1000F + (386F * 1.0F);

        assertEquals(
                expected,
                employee.CalculateYearBonus(),
                0.001F
        );
    }

    @Test
    void testCalculateYearBonusDifferentCurrency() {

        employee = new Employee(
                1000F,
                "EUR",
                10F,
                EmployeeType.Supervisor
        );

        float salario = 1000F * 0.95F;

        float expected = salario + (386F * 0.5F);

        assertEquals(
                expected,
                employee.CalculateYearBonus(),
                0.001F
        );
    }

    @Test
    void testCalculateYearBonusUSDByContent() {

        String currency = new String("USD");

        employee = new Employee(
                1000F,
                currency,
                10F,
                EmployeeType.Supervisor
        );

        float expected = 1000F + (386F * 0.5F);

        assertEquals(
                expected,
                employee.CalculateYearBonus(),
                0.001F
        );
    }

    // =========================================================
    // cs()
    // =========================================================

    @Test
    void testCsWorker() {

        employee = new Employee(
                1000F,
                "USD",
                10F,
                EmployeeType.Worker
        );

        int month = LocalDate.now().getMonthValue();

        float expected;

        if (month % 2 == 0) {
            expected = 1000F;
        } else {
            expected = 1000F + (386F / 12F * 2F);
        }

        assertEquals(
                expected,
                employee.cs(),
                0.001F
        );
    }

    @Test
    void testCsSupervisor() {

        employee = new Employee(
                1000F,
                "USD",
                10F,
                EmployeeType.Supervisor
        );

        int month = LocalDate.now().getMonthValue();

        float salario = 1000F;
        float valueS = salario + (10F * 0.35F);

        float expected;

        if (month % 2 == 0) {
            expected = valueS;
        } else {
            expected = valueS + (386F / 12F * 2F);
        }

        assertEquals(
                expected,
                employee.cs(),
                0.001F
        );
    }

    @Test
    void testCsManager() {

        employee = new Employee(
                1000F,
                "USD",
                10F,
                EmployeeType.Manager
        );

        int month = LocalDate.now().getMonthValue();

        float salario = 1000F;
        float valueM = salario + (10F * 0.7F);

        float expected;

        if (month % 2 == 0) {
            expected = valueM;
        } else {
            expected = valueM + (386F / 12F * 2F);
        }

        assertEquals(
                expected,
                employee.cs(),
                0.001F
        );
    }

    @Test
    void testCsDifferentCurrency() {

        employee = new Employee(
                1000F,
                "EUR",
                10F,
                EmployeeType.Supervisor
        );

        int month = LocalDate.now().getMonthValue();

        float salario = 1000F * 0.95F;
        float valueS = salario + (10F * 0.35F);

        float expected;

        if (month % 2 == 0) {
            expected = valueS;
        } else {
            expected = valueS + (386F / 12F * 2F);
        }

        assertEquals(
                expected,
                employee.cs(),
                0.001F
        );
    }

    @Test
    void testCsUSDByContent() {

        String currency = new String("USD");

        employee = new Employee(
                1000F,
                currency,
                10F,
                EmployeeType.Supervisor
        );

        int month = LocalDate.now().getMonthValue();

        float salario = 1000F;
        float valueS = salario + (10F * 0.35F);

        float expected;

        if (month % 2 == 0) {
            expected = valueS;
        } else {
            expected = valueS + (386F / 12F * 2F);
        }

        assertEquals(
                expected,
                employee.cs(),
                0.001F
        );
    }
}
