package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> findByKey(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (person.getName().contains(key)
                    || person.getSurname().contains(key)
                    || person.getPhone().contains(key)
                    || person.getAddress().contains(key)
            ) {
                result.add(person);
            }
        }
        return result;
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> nameCheck = person -> person.getName().contains(key);
        Predicate<Person> surnameCheck = person -> person.getSurname().contains(key);
        Predicate<Person> phoneCheck = person -> person.getPhone().contains(key);
        Predicate<Person> addresCheck = person -> person.getAddress().contains(key);

        Predicate<Person> combine = nameCheck.or(surnameCheck.or(phoneCheck.or(addresCheck)));
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
            result.add(person);
        }
    }
    return result;
    }
}
