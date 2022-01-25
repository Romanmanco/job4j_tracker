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
        Optional<User> user = findByPassport(passport);
        List<Account> accountList = users.get(user);
        if (!accountList.contains(account)) {
            accountList.add(account);
        }
    }

    /**
     * Метод для поиска паспорта.
     * @param passport метод позволяет найти паспорт.
     * @return возвращает паспорт.
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (var user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
            }
        }
        return rsl;
    }

    /**
     * Метод находит аккаунт по реквизитам.
     * @param passport - используется, для первичного поиска аккаунта.
     * @param requisite - используются для поиска внутри списка аккаунтов.
     * @return возвращает реквизиты.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        Optional<User> user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(u -> u.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return account;
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

    public static void main(String[] args) {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> opt = bank.findByPassport("3211");
        if (opt.isPresent()) {
            System.out.println(opt.get().getUsername());
        }
    }
}
