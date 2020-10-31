package com.example.restservice.domain;

public class Calculator {

  public int multiply(final int x, final int y) {
    return x * y;
  }

  public double divide(final int x, final int y) {
    if (y == 0) throw new IllegalArgumentException("divide by zero");
    return (double)x / (double)y;
  }
}
