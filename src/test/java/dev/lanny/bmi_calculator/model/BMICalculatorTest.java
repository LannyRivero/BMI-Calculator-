package dev.lanny.bmi_calculator.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BMICalculatorTest {
    @Test
    @DisplayName("Validad calcular IMC con entrada válida")
    void testCalculateBMI(){
        BMICalculator calculator = new BMICalculator();
        double bmi = calculator.calculateBMI(70, 1.75 );
        assertThat(bmi, closeTo(22.86,0.01));
    }

    @Test
    @DisplayName("Validar calcular IMC con una entrada Invalidad- peso negativo")
    void testCalculateBMI_InvalidWeght(){
        BMICalculator calculator = new BMICalculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateBMI(-70,1.75));
    }

    @Test
    @DisplayName("Validadr calcular IMC con entrada invalida -altura cero")
    void testCalculateBMI_InvalidHeight(){
        BMICalculator calculator = new BMICalculator();
        assertThrows(IllegalArgumentException.class, ()-> calculator.calculateBMI(70, 0));
    }

    @Test 
    @DisplayName("categoria de IMC -Peso Normal")
    void testGetBMICategory_NormalWeight(){
        BMICalculator calculator = new BMICalculator();
        String category = calculator.getBMICategory(22);
        assertThat(category, is("Peso Normal"));
    }

    @Test
    @DisplayName("Categoria de IMC - Sobrepeso")
    void testGetBMICategory_Overweight(){
        BMICalculator calculator = new BMICalculator();
        String category = calculator.getBMICategory(27);
        assertThat(category, is("Sobrepeso"));
    }

    @Test
    @DisplayName("Categoria de IMC -Obesidad clase III")
    void testGetBMICategory_ObesityClassIII(){
        BMICalculator calculator = new BMICalculator();
        String category = calculator.getBMICategory(42);
        assertThat(category, is("Obesidad tipo III"));
    }
}
