package dev.lanny.bmi_calculator.controller;

import dev.lanny.bmi_calculator.model.BMICalculator;

public class BMIController {
    private final BMICalculator calculator;

    public BMIController() {
        this.calculator = new BMICalculator();
    }
    
    public BMIController(BMICalculator calculator) {
        this.calculator = calculator;
    }

    public double calculateBMI(double weight, double height) {
      
        return calculator.calculateBMI(weight, height);
    }

    public String getBMICategory(double weight, double height) {
        double bmi = calculateBMI(weight, height);
        return calculator.getBMICategory(bmi);     
        
    }
    }


