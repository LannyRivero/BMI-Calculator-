package dev.lanny.bmi_calculator.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class BMIControllerTest {
   
    private final BMIController controller = new BMIController();

@Test 
@DisplayName("Calcular IMC con valores válidos")
void testCalculatedBMI_ValidValues(){
    double bmi = controller.calculateBMI(70, 1.75);
    assertThat(bmi, closeTo(22.86,0.01));
    }

    @Test
    @DisplayName("Obtener categoría de IMC - Sobrepeso")
    void testGetBMICategory_Overweight() {
        String category = controller.getBMICategory(85.0, 1.75); 
        assertThat(category, is("Sobrepeso"));
    }

    @Test
    @DisplayName("Obtener categoría de IMC - Obesidad tipo III")
    void testGetBMICategory_ObesityClassIII() {
        String category = controller.getBMICategory(120.0, 1.60); 
        assertThat(category, is("Obesidad tipo III"));
    }
}
