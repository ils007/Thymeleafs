package com.example.demo3.Repository;

import java.util.Date;
import java.util.List;

import com.example.demo3.Entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    public List<Person> findByFullNameLike(String name);

    public List<Person> findByDateOfBirthGreaterThan(Date date);

}
