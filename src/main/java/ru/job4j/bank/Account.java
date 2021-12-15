package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает аккаунт банковского клиента,
 * включает в себя конструктор, геттеры и сеттеры.
 * @author Roman Manco
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double  balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Для корректной работы переопределены методы equals и hashCode.
     * @param o - аккаунт.
     * @return возвращает сравнение по реквизитам аккаунта.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
