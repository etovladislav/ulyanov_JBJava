package ru.kpfu.itis.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.People;
import ru.kpfu.itis.model.enums.PeopleType;
import ru.kpfu.itis.repository.MedClinicRepository;
import ru.kpfu.itis.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    MedClinicRepository medClinicRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Integer getId(People people) {
        Query query = entityManager.createNativeQuery("SELECT p.id FROM people p WHERE " +
                "p.pasport_series = ? AND p.pasport_number = ? AND p.pasport_issues = ?");
        query.setParameter(1, people.getPasportSeries());
        query.setParameter(2, people.getPasportNumber());
        query.setParameter(3, people.getPasportIssues());
        return (Integer) query.getSingleResult();
    }

    @Override
    public PeopleType getType(People people) {
        Query query = entityManager.createNativeQuery("SELECT p.type FROM people p WHERE " +
                "p.pasport_series = ? AND p.pasport_number = ? AND p.pasport_issues = ?");
        query.setParameter(1, people.getPasportSeries());
        query.setParameter(2, people.getPasportNumber());
        query.setParameter(3, people.getPasportIssues());
        return (PeopleType) query.getSingleResult();
    }

    @Override
    public Double getSalary(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT salary * expected_time FROM stuff_data WHERE" +
                " people_id = ?");
        query.setParameter(1, id);
        return (Double) query.getSingleResult();
    }

    @Override
    public Double getCheck(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT cost FROM patient_data WHERE people_id = ?");
        query.setParameter(1, id);
        return (Double) query.getSingleResult();
    }

    @Override
    public Date getDate(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT creation_date FROM stuff_data WHERE people_id = ?");
        query.setParameter(1, id);
        return (Date) query.getSingleResult();
    }
}
