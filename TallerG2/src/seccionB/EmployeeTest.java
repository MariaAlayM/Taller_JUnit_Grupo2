package seccionB;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

    
    @Test
    void testWorkerSalaryUSD() {

        Employee employee = new Employee(386.0F,"USD",0.0F,EmployeeType.Worker);

        float resultado = employee.cs();
        int mes = LocalDate.now().getMonthValue();
        float esperado;
        if (mes % 2 == 0) {
            esperado = 386.0F;
        } else {
            esperado = 386.0F + (386.0F / 12 * 2);
        }

        assertEquals(esperado, resultado, 0.01F);
    }

    @Test
    void testWorkerSalaryOtherCurrency() {

        Employee employee = new Employee(386.0F,"EUR",0.0F,EmployeeType.Worker);

        float resultado = employee.cs();
        int mes = LocalDate.now().getMonthValue();
        float salario = 386.0F * 0.95F;
        float esperado;

        if (mes % 2 == 0) {
            esperado = salario;
        } else {
            esperado = salario + (386.0F / 12 * 2);
        }

        assertEquals(esperado, resultado, 0.01F);
    }

    @Test
    void testSupervisorSalaryUSD() {

        Employee employee = new Employee(1000.0F,"USD",100.0F,EmployeeType.Supervisor);

        float resultado = employee.cs();
        int mes = LocalDate.now().getMonthValue();
        float salario = 1000.0F + (100.0F * 0.35F);
        float esperado;

        if (mes % 2 == 0) {
            esperado = salario;
        } else {
            esperado = salario + (386.0F / 12 * 2);
        }

        assertEquals(esperado, resultado, 0.01F);
    }
    
    @Test
    void testSupervisorSalaryOtherCurrency() {

        Employee employee = new Employee(1000.0F,"EUR",100.0F,EmployeeType.Supervisor);

        float resultado = employee.cs();

        int mes = LocalDate.now().getMonthValue();

        float salarioConvertido = 1000.0F * 0.95F;
        float salarioConBono = salarioConvertido + (100.0F * 0.35F);

        float esperado;

        if (mes % 2 == 0) {
            esperado = salarioConBono;
        } else {
            esperado = salarioConBono + (386.0F / 12 * 2);
        }

        assertEquals(esperado, resultado, 0.01F);
    }

    @Test
    void testManagerSalaryUSD() {

        Employee employee = new Employee(1000.0F,"USD",100.0F,EmployeeType.Manager);

        float resultado = employee.cs();

        int mes = LocalDate.now().getMonthValue();

        float salario = 1000.0F + (100.0F * 0.70F);

        float esperado;

        if (mes % 2 == 0) {
            esperado = salario;
        } else {
            esperado = salario + (386.0F / 12 * 2);
        }

        assertEquals(esperado, resultado, 0.01F);
    }

    @Test
    void testManagerSalaryOtherCurrency() {

        Employee employee = new Employee(
                1000.0F,
                "EUR",
                100.0F,
                EmployeeType.Manager
        );

        float resultado = employee.cs();

        int mes = LocalDate.now().getMonthValue();

        float salarioConvertido = 1000.0F * 0.95F;
        float salarioConBono = salarioConvertido + (100.0F * 0.70F);

        float esperado;

        if (mes % 2 == 0) {
            esperado = salarioConBono;
        } else {
            esperado = salarioConBono + (386.0F / 12 * 2);
        }

        assertEquals(esperado, resultado, 0.01F);
    }

    @Test
    void testWorkerYearBonus() {

        Employee employee = new Employee(1000.0F,"USD",0.0F,EmployeeType.Worker);

        float resultado = employee.CalculateYearBonus();

        assertEquals(386.0F, resultado, 0.01F);
    }

    @Test
    void testSupervisorYearBonus() {

        Employee employee = new Employee(1000.0F,"USD",100.0F,EmployeeType.Supervisor);

        float resultado = employee.CalculateYearBonus();

        float esperado = 1000.0F + (386.0F * 0.5F);

        assertEquals(esperado, resultado, 0.01F);
    }

     @Test
    void testManagerYearBonus() {

        Employee employee = new Employee(1000.0F,"USD",100.0F,EmployeeType.Manager );
                

        float resultado = employee.CalculateYearBonus();
        float esperado = 1000.0F + (386.0F * 1.0F);
        assertEquals(esperado, resultado, 0.01F);
    }

    @Test
    void testSupervisorYearBonusOtherCurrency() {

        Employee employee = new Employee(
                1000.0F,
                "EUR",
                100.0F,
                EmployeeType.Supervisor
        );

        float resultado = employee.CalculateYearBonus();
        float salarioConvertido = 1000.0F * 0.95F;
        float esperado = salarioConvertido + (386.0F * 0.5F);
        assertEquals(esperado, resultado, 0.01F);
    }

     @Test
    void testManagerYearBonusOtherCurrency() {

        Employee employee = new Employee(
                1000.0F,
                "EUR",
                100.0F,
                EmployeeType.Manager
        );

        float resultado = employee.CalculateYearBonus();
        float salarioConvertido = 1000.0F * 0.95F;
        float esperado = salarioConvertido + 386.0F;
        assertEquals(esperado, resultado, 0.01F);
    }

    @Test
    void testWorkerYearBonusOtherCurrency() {

        Employee employee = new Employee(
                1000.0F,
                "EUR",
                0.0F,
                EmployeeType.Worker
        );

        float resultado = employee.CalculateYearBonus();

        assertEquals(386.0F, resultado, 0.01F);
    }


}

