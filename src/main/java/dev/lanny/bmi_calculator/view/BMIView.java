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
        Scanner scanner = new Scanner(System.in); 
        boolean continueCalculating = true;

        System.out.println("Depuración: Ingresó al bucle.");

    
        while (continueCalculating) {
            System.out.println("=================================");
            System.out.println("       CALCULADORA DE IMC       ");
            System.out.println("=================================");
    
            try {
                // Solicitar el peso
                System.out.print("\nIngrese su peso (kg): ");
                String weightInput = scanner.nextLine().trim();
                double weight = Double.parseDouble(weightInput);
                if (weight <= 10 || weight > 500) {
                    throw new IllegalArgumentException("El peso debe estar entre 10 y 500 kg.");
                }
    
                // Solicitar la altura
                System.out.print("Ingrese su altura en metros (ejemplo: 1.75): ");
                String heightInput = scanner.nextLine().trim();
                double height = Double.parseDouble(heightInput);
                if (height <= 0.5 || height > 2.5) {
                    throw new IllegalArgumentException("La altura debe estar entre 0.5 y 2.5 metros.");
                }
    
                // Calcular IMC y categoría
                double bmi = controller.calculateBMI(weight, height);
                String category = controller.getBMICategory(weight, height);
    
                // Mostrar resultados
                System.out.println("\n---------------------------------");
                System.out.println("     RESULTADOS DEL CÁLCULO     ");
                System.out.println("---------------------------------");
                System.out.printf(Locale.US, "Su IMC es: %.2f\n", bmi);
                System.out.println("Categoría de IMC: " + category);
    
                // Preguntar si desea continuar
                System.out.print("\n¿Desea calcular otro IMC? (s/n): ");
                String response = scanner.nextLine().trim();
                if (!response.equalsIgnoreCase("s") && !response.equalsIgnoreCase("n")) {
                    System.out.println("\nEntrada no válida. Saliendo del programa.");
                    break;
                }
                continueCalculating = response.equalsIgnoreCase("s");
    
            } catch (NumberFormatException e) {
                System.out.println("\nError: Entrada no válida. Por favor, ingrese números válidos.");
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
            } catch (Exception e) {
                System.out.println("\nOcurrió un error inesperado. Intente de nuevo.");
            }
        }
    
        System.out.println("\n¡Gracias por usar la Calculadora de IMC!");
        scanner.close();
    }
}