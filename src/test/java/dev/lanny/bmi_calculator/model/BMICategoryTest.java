package dev.lanny.bmi_calculator.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BMICategoryTest {
    @Test
    @DisplayName("Categoría de IMC - Delgadez severa")
    void testGetBMICategory_SevereThinness() {
        assertThat(BMICategory.getCategory(15), is("Delgadez severa"));
    }

    @Test
    @DisplayName("Categoría de IMC - Peso normal")
    void testGetBMICategory_NormalWeight() {
        assertThat(BMICategory.getCategory(22), is("Peso Normal"));
    }

    @Test
    @DisplayName("Categoría de IMC - Sobrepeso")
    void testGetBMICategory_Overweight() {
        assertThat(BMICategory.getCategory(27), is("Sobrepeso"));
    }

    @Test
    @DisplayName("Categoría de IMC - Obesidad tipo III")
    void testGetBMICategory_ObesityClassIII() {
        assertThat(BMICategory.getCategory(42), is("Obesidad tipo III"));
    }

    @Test
    @DisplayName("Categoría de IMC - Valor inválido")
    void testGetBMICategory_InvalidValue() {
        assertThat(BMICategory.getCategory(-5), is("Valor inválido"));
    }
}
