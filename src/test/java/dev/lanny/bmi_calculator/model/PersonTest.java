package dev.lanny.bmi_calculator.model;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.DisplayName;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    @Test
    @DisplayName("Validar crear objeto Persona con entradas válidas")
    void testPersonValidInputs(){
        Person person = new Person(70, 1.75);
        assertThat(person.getWeight(), is(70.0));
        assertThat(person.getHeight(), is(1.75));
    }

    @Test
    @DisplayName("Validad crear objeto Persona con entardas inválidas")
    void testPersonInvalidInputs(){
        assertThrows(IllegalArgumentException.class, () -> new Person(-70, 1.75));
        assertThrows(IllegalArgumentException.class, () -> new Person(70, 0) );

    }

    @Test
    @DisplayName("Actualizar peso válido en Persona")
    void testSetValidWeight() {
        Person person = new Person(70, 1.75);
        person.setWeight(80);
        assertThat(person.getWeight(), is(80.0));
    }

    @Test
    @DisplayName("Actualizar altura válida en Persona")
    void testSetValidHeight() {
        Person person = new Person(70, 1.75);
        person.setHeight(1.80);
        assertThat(person.getHeight(), is(1.80));
    }

    @Test
    @DisplayName("Intentar actualizar peso con valor inválido")
    void testSetInvalidWeight() {
        Person person = new Person(70, 1.75);
        assertThrows(IllegalArgumentException.class, () -> person.setWeight(-10));
    }

    @Test
    @DisplayName("Intentar actualizar altura con valor inválido")
    void testSetInvalidHeight() {
        Person person = new Person(70, 1.75);
        assertThrows(IllegalArgumentException.class, () -> person.setHeight(0));
    }
}
