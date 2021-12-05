package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> dataBase = new HashMap<>();
        dataBase.put("romanmanco@gmail.com ", "Manco Roman Sergeevich");
        for (String key : dataBase.keySet()) {
            String value = dataBase.get(key);
            System.out.println(key + value);
        }
    }
}
