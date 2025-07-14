package com.cybersoft.demospringboot09.Buoi34.bai04;

public class CalculateService {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public Double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        double result = (double) a / b;
        return result;
    }
}
