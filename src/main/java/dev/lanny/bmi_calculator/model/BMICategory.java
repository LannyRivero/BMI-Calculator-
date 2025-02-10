package dev.lanny.bmi_calculator.model;

public enum BMICategory {
    SEVERE_THINNESS("Delgadez severa", 0, 16),
    MODERATE_THINNESS("Delgadez moderada", 16, 17),
    MILD_THINNESS("Delgadez leve", 17, 18.5),
    NORMAL("Peso Normal", 18.5, 25),
    OVERWEIGHT("Sobrepeso", 25, 30),
    OBESITY_I("Obesidad tipo I", 30, 35),
    OBESITY_II("Obesidad tipo II", 35, 40),
    OBESITY_III("Obesidad tipo III", 40, Double.MAX_VALUE);

    private final String description;
    private final double min;
    private final double max;

    BMICategory(String description, double min, double max) {
        this.description = description;
        this.min = min;
        this.max = max;
    }

    public static String getCategory(double bmi) {
        for (BMICategory category : values()) {
            if (bmi >= category.min && bmi < category.max) {
                return category.description;
            }
        }
        return "Valor inválido";
    }
    
}
