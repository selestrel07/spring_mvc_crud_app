package ru.selestrel.learn.spring.dao;

import org.springframework.stereotype.Component;
import ru.selestrel.learn.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tim"));
        people.add(new Person(++PEOPLE_COUNT, "Stick"));
        people.add(new Person(++PEOPLE_COUNT, "Heim"));
        people.add(new Person(++PEOPLE_COUNT, "Sally"));
        people.add(new Person(++PEOPLE_COUNT, "Dorry"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
