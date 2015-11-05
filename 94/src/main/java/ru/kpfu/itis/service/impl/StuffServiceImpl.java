package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.People;
import ru.kpfu.itis.repository.PersonRepository;
import ru.kpfu.itis.service.StuffService;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class StuffServiceImpl implements StuffService {

    private static final Logger log = Logger.getLogger(StuffServiceImpl.class.getName());

    @Autowired
    PersonRepository personRepository;

    @Override
    public Double getStuffSalary(People people) {
        try {
            return personRepository.getSalary(personRepository.getId(people));
        } catch (NoResultException e) {
            log.info("No result");
            return null;
        }
    }

    @Override
    public Date getEmployedDate(People people) {
        try {
            return personRepository.getDate(personRepository.getId(people));
        } catch (NoResultException e) {
            log.info("No result");
            return null;
        }
    }
}
