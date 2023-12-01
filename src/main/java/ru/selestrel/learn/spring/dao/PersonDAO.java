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

        people.add(new Person(++PEOPLE_COUNT, "Tim", 21, "tim@test.com"));
        people.add(new Person(++PEOPLE_COUNT, "Stick", 25, "stick@test.com"));
        people.add(new Person(++PEOPLE_COUNT, "Heim", 32, "heim@test.com"));
        people.add(new Person(++PEOPLE_COUNT, "Sally", 21, "sally@test.com"));
        people.add(new Person(++PEOPLE_COUNT, "Dorry", 17, "dorry@test.com"));
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

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
