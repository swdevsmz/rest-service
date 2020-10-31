package com.example.restservice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  public void multiplyで3と4の乗算結果が取得できる() {
    Calculator calc = new Calculator();
    int expected = 12;
    int actual = calc.multiply(3, 4);
    assertThat(actual, is(expected));
  }

  @Test
  public void divideで5と0のときにIllegalArgumentExceptionが送信される(){
    assertThrows(IllegalArgumentException.class, () -> new Calculator().divide(5, 0));
  }
}
