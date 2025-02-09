package dev.lanny.bmi_calculator.view;
import java.util.Locale;
import java.util.Scanner;
import dev.lanny.bmi_calculator.controller.BMIController;

public class BMIView {

    private final BMIController controller;

    public BMIView(BMIController controller) {
        this.controller = controller;
    }



    public void start() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        boolean continueCalculating = true;

        while (continueCalculating) {
            System.out.println("=================================");
            System.out.println("       CALCULADORA DE IMC       ");
            System.out.println("=================================");

            try {
                System.out.print("\nIngrese su peso (kg): ");
                double weight = Double.parseDouble(scanner.next().trim());

                System.out.print("Ingrese su altura (m): ");
                double height = Double.parseDouble(scanner.next().trim());

                double bmi = controller.calculateBMI(weight, height);
                String category = controller.getBMICategory(weight, height);

                System.out.println("\n---------------------------------");
                System.out.println("     RESULTADOS DEL CÁLCULO     ");
                System.out.println("---------------------------------");
                System.out.printf(Locale.US, "Su IMC es: %.2f\n", bmi);
                System.out.println("Categoría de IMC: " + category);

                System.out.print("\n¿Desea calcular otro IMC? (s/n): ");
                String response = scanner.next().trim();
                continueCalculating = response.equalsIgnoreCase("s");

            } catch (NumberFormatException e) {
                System.out.println("\nError: Entrada no válida. Por favor, ingrese números.");
            } catch (Exception e) {
                System.out.println("\nOcurrió un error. Intente de nuevo.");
            }
        }

        System.out.println("\n¡Gracias por usar la Calculadora de IMC!");
        scanner.close();
    }
    
}
    

