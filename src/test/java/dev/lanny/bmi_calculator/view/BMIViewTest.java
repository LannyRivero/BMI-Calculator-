package dev.lanny.bmi_calculator.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import dev.lanny.bmi_calculator.controller.BMIController;
import dev.lanny.bmi_calculator.model.BMICalculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class BMIViewTest {

    @Test
    @DisplayName("Se prueba que se complete el flujo con valores válidos")
    void testBMIViewWithValidInput() {

        String simulatedInput = "70\n1.75\nn\n";
        ByteArrayInputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        try {
            BMIController controller = new BMIController(new BMICalculator());
            BMIView view = new BMIView(controller);

            view.start();

            String consoleOutput = output.toString();
            assertThat(consoleOutput, containsString("Su IMC es: 22.86"));
            assertThat(consoleOutput, containsString("Categoría de IMC: Peso Normal"));
            assertThat(consoleOutput, containsString("¡Gracias por usar la Calculadora de IMC!"));

        } finally {
            System.setOut(System.out);
            System.setIn(System.in);
        }
    }

    
}
