package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса, где можно добавить/найти пользователя
 * и отправить денежные средства.
 * @author Roman Manco
 * @version 2.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавления пользователя
     *
     * @param user добавляется в ArrayList
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод создания аккаунта, содержит в себе проверку чтобы не задублировать
     * пользователя по одному и тому же паспорту.
     *
     * @param passport возвращает паспорт пользователя.
     * @param account  добавляется, если паспорт уникален.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> userAccounts = users.get(user.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод для поиска паспорта.
     *
     * @param passport метод позволяет найти паспорт.
     * @return возвращает паспорт.
     * Метод findFirst возвращает тип Optional.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод находит аккаунт по реквизитам.
     *
     * @param passport  - используется, для первичного поиска аккаунта.
     * @param requisite - используются для поиска внутри списка аккаунтов.
     * @return возвращает реквизиты.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user
                .flatMap(value -> users.get(value).stream()
                        .filter(account -> requisite.equals(
                                account.getRequisite()))
                        .findFirst());
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
            Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
            Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);

            if (destAccount.isPresent()
                    && srcAccount.isPresent()
                    && srcAccount.get().getBalance() >= amount) {
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                rsl = true;
            }
            return rsl;
        }
}