package com.sapient;

public class Holding {
	
    private String name;
    
    private double value;

    public Holding(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}