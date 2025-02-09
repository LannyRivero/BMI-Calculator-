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
    @DisplayName("Prueba de flujo completo con formato mejorado")
    void testBMIViewWithImprovedFormat() {
        // Simular entrada del usuario
        String simulatedInput = "70\n1.75\nn\n"; // Peso: 70kg, Altura: 1.75m, y salir
        ByteArrayInputStream input = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(input);

        // Capturar la salida
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        try {
            // Configurar el controlador y la vista
            BMIController controller = new BMIController(new BMICalculator());
            BMIView view = new BMIView(controller);

            // Ejecutar el programa
            view.start();

            // Obtener la salida de la consola
            String consoleOutput = output.toString();

            // Verificar las secciones visuales y los resultados
            assertThat(consoleOutput, containsString("================================="));
            assertThat(consoleOutput, containsString("       CALCULADORA DE IMC       "));
            assertThat(consoleOutput, containsString("Ingrese su peso (kg):"));
            assertThat(consoleOutput, containsString("Ingrese su altura (m):"));
            assertThat(consoleOutput, containsString("---------------------------------"));
            assertThat(consoleOutput, containsString("     RESULTADOS DEL CÁLCULO     "));
            assertThat(consoleOutput, containsString("Su IMC es: 22.86"));
            assertThat(consoleOutput, containsString("Categoría de IMC: Peso Normal"));
            assertThat(consoleOutput, containsString("¿Desea calcular otro IMC? (s/n):"));
            assertThat(consoleOutput, containsString("¡Gracias por usar la Calculadora de IMC!"));

        } finally {
            // Restaurar los flujos originales
            System.setOut(System.out);
            System.setIn(System.in);
        }
    }
}


