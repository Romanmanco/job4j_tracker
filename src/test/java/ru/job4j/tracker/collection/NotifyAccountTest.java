package ru.job4j.tracker.collection;

import org.junit.Test;
import ru.job4j.collection.Account;
import ru.job4j.collection.NotifyAccount;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void deleteDuplicate() {
        List<Account> accounts = Arrays.asList(
                new Account("1", "Crocodile", "one billion"),
                new Account("1", "Crocodile", "one billion"),
                new Account("2", "Horse", "two billion")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("1", "Crocodile", "one billion"),
                        new Account("2", "Horse", "two billion")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}
