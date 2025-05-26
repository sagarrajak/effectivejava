package com.effectivejava.practice.generics;

import java.util.Arrays;
import java.util.List;

public class ArrayGenerics {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<? extends Number> numbers = list;
//        numbers.set(2, 3.14);
    }
}

interface MyCollection<T> {
    boolean contains(T value);
    boolean containsAll(MyCollection<?> collection);
}
