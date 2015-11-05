package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.People;
import ru.kpfu.itis.model.enums.PeopleType;

import java.util.Date;


public interface PersonRepository {

    Integer getId(People people);

    PeopleType getType(People people);

    Double getSalary(Integer id);

    Double getCheck(Integer id);

    Date getDate(Integer id);
}
