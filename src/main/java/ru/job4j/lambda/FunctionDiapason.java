package ru.job4j.lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class FunctionDiapason {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> res = new LinkedList<>();
        for (double i = start; i < end; i++) {
            res.add(func.apply(i));
        }
        return res;
    }
}
