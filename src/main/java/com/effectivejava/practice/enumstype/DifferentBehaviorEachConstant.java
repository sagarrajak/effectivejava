package com.effectivejava.practice.enumstype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * THis example will show sometime if we want to assocoate each
 * enum with different behaviours
 */
public class DifferentBehaviorEachConstant {

    public enum OperationIncorrect {
        PLUS,
        MINUS,
        TIMES,
        DIVIDE;

        // this works but will be not good if we add another enum
        public double apply(double a, double b) {
            return switch (this) {
                case PLUS -> a + b;
                case MINUS -> a - b;
                case TIMES -> a * b;
                case DIVIDE -> a / b;
                default -> throw new AssertionError();
            };
        }
    }


    // Here this will force it to override this when we add new enum in this
    public enum OperationCorrect {
        PLUS("+") {
            @Override
            public double apply(double a, double b) {
                return a+b;
            }
        },
        MINUS("-") {
            @Override
            public double apply(double a, double b) {
                return a-b;
            }
        },
        TIMES("*") {
            @Override
            public double apply(double a, double b) {
                return a*b;
            }
        },
        DIVIDE("/") {
            @Override
            public double apply(double a, double b) {
                return a/b;
            }
        };

        private final String symbol;
        OperationCorrect(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }

        private static final Map<String, OperationCorrect> stringToEnum =
                Stream.of(values()).collect(
                        toMap(OperationCorrect::toString, e -> e)
                );

        public static Optional<OperationCorrect> fromString(String symbol) {
            return Optional.ofNullable(stringToEnum.get(symbol));
        }

        public abstract double apply(double a, double b);
    }

    public static void main(String[] args) throws IOException {
        var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double first = Double.parseDouble(bufferedReader.readLine());
        double second = Double.parseDouble(bufferedReader.readLine());
        String  operation = bufferedReader.readLine();
//        double result = OperationCorrect.DIVIDE.apply(first, second);
//
        double finalResult = OperationCorrect.fromString(operation).orElseThrow(AssertionError::new).apply(first, second);
        System.out.printf("%f%s%f %f\n",first, operation, second, finalResult);
    }
}


