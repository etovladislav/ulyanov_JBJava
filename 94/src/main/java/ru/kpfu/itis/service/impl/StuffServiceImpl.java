package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.People;
import ru.kpfu.itis.repository.PersonRepository;
import ru.kpfu.itis.service.StuffService;

import javax.persistence.NoResultException;
import java.util.Date;

@Service
public class StuffServiceImpl implements StuffService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Double getStuffSalary(People people) {
        try {
            return personRepository.getSalary(personRepository.getId(people));
        } catch (NoResultException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Date getEmployedDate(People people) {
        try {
            return personRepository.getDate(personRepository.getId(people));
        } catch (NoResultException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
