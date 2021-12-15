package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса, где можно добавить/найти пользователя
 * и отправить денежные средства.
 * @author Roman Manco
 * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавления пользователя
     * @param user добавляется в ArrayList
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод создания аккаунта, содержит в себе проверку чтобы не задублировать
     * пользователя по одному и тому же паспорту.
     * @param passport возвращает паспорт пользователя.
     * @param account добавляется, если паспорт уникален.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Метод для поиска паспорта.
     * @param passport метод позволяет найти паспорт.
     * @return возвращает паспорт.
     */
    public User findByPassport(String passport) {
        User us = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                us = user;
                break;
            }
        } return us;
    }

    /**
     * Метод находит аккаунт по реквизитам.
     * @param passport - используется, для первичного поиска аккаунта.
     * @param requisite - используются для поиска внутри списка аккаунтов.
     * @return возвращает реквизиты.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account acc = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            for (Account account : accountList) {
                if (account.getRequisite().equals(requisite)) {
                    acc = account;
                    break;
                }
            }
        }
        return acc;
    }

    /**
     * Метод позволяет отправить денежные средства с одного аккаунта на другой
     * @param srcPassport - паспорт клиента отправляющего деньги.
     * @param srcRequisite - реквизиты клиента отправляющего деньги.
     * @param destPassport - паспорт клиента получающего деньги.
     * @param destRequisite - реквизиты клиента получающего деньги.
     * @param amount - сумма переводимая с одного аккаунта на другой, убавляется у отправляющего клиента
     * и прибавляется у получающего.
     * @return возвращает результат операции
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if (destAccount != null && srcAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
