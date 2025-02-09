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
}
