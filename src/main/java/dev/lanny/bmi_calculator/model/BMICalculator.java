package dev.lanny.bmi_calculator.model;


    public class BMICalculator {
        public double calculateBMI(double weight, double height) {
            if (weight <= 0 || height <= 0) {
                throw new IllegalArgumentException("El peso y la altura deben ser mayores que cero.");
            }
            return weight / Math.pow(height, 2);
        }
    
        public String getBMICategory(double bmi) {
            return BMICategory.getCategory(bmi);
        }
    }

