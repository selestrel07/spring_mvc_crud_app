package ru.selestrel.learn.spring.dao;

import org.springframework.stereotype.Component;
import ru.selestrel.learn.spring.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static final String URL = "jdbc:postgresql://localhost:3004/springmvc";
    private static final String USER_NAME = "selestrel";
    private static final String PASSWORD = "123qwe123";

    private static Connection connection;

    {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return people;
    }

    public Person show(int id) {
//        return people.stream()
//                .filter(person -> person.getId() == id)
//                .findFirst()
//                .orElse(null);
        return null;
    }

    public void save(Person person) {

        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO person VALUES(" + 1 + ", '" + person.getName() + "', "
                    + person.getAge() + ", '" + person.getEmail() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
//        people.removeIf(person -> person.getId() == id);
    }
}
