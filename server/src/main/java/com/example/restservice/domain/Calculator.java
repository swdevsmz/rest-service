package com.example.restservice.domain;

public class Calculator {

  /**
   * 乗算を行います.
   *
   * @param x X
   * @param y Y
   * @return 乗算結果
   */
  public int multiply(final int x, final int y) {
    return x * y;
  }

  /**
   * 除算を行います.
   *
   * @param x X
   * @param y Y
   * @return 除算結果
   */
  public double divide(final int x, final int y) {
    if (y == 0) {
      throw new IllegalArgumentException("divide by zero");
    }
    return (double) x / (double) y;
  }
}
