package com.taxah.unit_test.DZ1.Calculator;
import static org.assertj.core.api.Assertions.*;
public class Calculator {
    public static double calculation(double firstOperand, double secondOperand, char operator) {
        double result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double num) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые
            if(num < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of a negative number");
            }
            return Math.sqrt(num);
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        assertThat(purchaseAmount).withFailMessage("Price is too low").isGreaterThan(0);
        assertThat(discountAmount)
                .withFailMessage("Discount is wrong, must be between 0 - 75")
                .isGreaterThan(0).isLessThanOrEqualTo(75);
        try {
            assertThat(calculation(purchaseAmount, discountAmount, '*')).isGreaterThan(100);
        }catch (AssertionError e){
            throw new ArithmeticException("Price * discount ->" + e.getMessage());
        }
        return calculation(purchaseAmount,(
                calculation((
                                calculation(purchaseAmount,  discountAmount, '*')),
                        100.0,'/')),'-'); // this equal: price-((price*discount)/100)
    }
}