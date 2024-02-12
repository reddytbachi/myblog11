package com.myblog.myblog11;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

import java.util.function.Supplier;
import java.util.stream.Collectors;


public class TestClass1 {
    public static void main(String[] args) {
        List<Integer> number=Arrays.asList(10,32,4,21,25,60);
        List<Integer> result = number.stream().filter(n1 -> n1 % 2 == 0).map(n2 -> n2 * n2).collect(Collectors.toList());
        System.out.println(result);
    }
}

