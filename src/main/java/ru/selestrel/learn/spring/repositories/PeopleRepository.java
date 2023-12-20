package ru.selestrel.learn.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.selestrel.learn.spring.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
