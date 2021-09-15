package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI extends Item{

    public void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = Item.getCreated().format(formatter);
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Текущие дата и время до форматирования: " + currentDateTime);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
    }
}
