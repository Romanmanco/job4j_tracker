package ru.job4j.tracker.seach;

import org.junit.Test;
import ru.job4j.search.Person;
import ru.job4j.search.PhoneDictionary;

import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenNotFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Dmitry", "Fursa", "456675", "Moscow")
        );
        try {
            ArrayList<Person> persons = phones.find("Petr");
            assertThat(persons.get(0).getName(), is("Dmitry"));
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Пользователя нет в списке.");
        }
    }

    @Test
    public void whenEmpty() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Denis", "Budeny", "456675", "Moscow")
        );
        ArrayList<Person> persons = phones.find("Maxim");
        assertThat(persons.isEmpty(), is(true));
    }
}
