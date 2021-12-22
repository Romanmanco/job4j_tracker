package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = ((integer, s) -> System.out.println(integer + s));
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");

        BiPredicate<Integer, String> biPred = ((i, s) -> i.toString().contains(s));
        for (Integer integer : map.keySet()) {
            if (biPred.test(integer, map.get(integer))) {
                System.out.println("key: " + integer + " value: " + map.get(integer));
            }
        }
        Supplier<List<String>> sup = () -> (List<String>) map.values();

        Consumer<String> con = str -> System.out.println(str);
        Function<String, String> func = s -> s.toUpperCase();
        System.out.println(func);
    }
}
