package dev.lanny.bmi_calculator;

import dev.lanny.bmi_calculator.controller.BMIController;
import dev.lanny.bmi_calculator.model.BMICalculator;
import dev.lanny.bmi_calculator.view.BMIView;

public final class App {
    
    private App() {
    }

    public static void main(String[] args) {  
        
            BMICalculator calculator = new BMICalculator();   
            BMIController controller = new BMIController(calculator);   
            BMIView view = new BMIView(controller);

            view.start();
        }
}
