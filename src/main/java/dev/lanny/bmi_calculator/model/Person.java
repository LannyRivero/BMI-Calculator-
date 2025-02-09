package dev.lanny.bmi_calculator.model;

public class Person {
    private double weight;
    private double height;

    public Person(double weight, double height) {
        if (weight <=0 || height <=0) {
            throw new IllegalArgumentException("El peso y la altura deben ser mayores que cero.");            
        }
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() { return weight;}
    public double getHeight() { return height;}

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero.");
        }
        this.weight = weight;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que cero.");
        }
        this.height = height;
    }

}
