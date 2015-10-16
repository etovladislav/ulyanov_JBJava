package ru.kpfu.itis.repository.iml;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by Vladislav on 16.10.2015.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Integer findStudentByNameSurnameLasName(String firstname, String surname, String lastName) {

        System.out.println(firstname+lastName+surname);
        Query query = em.createNativeQuery("SELECT id FROM students WHERE firstname = ? AND surname = ? AND lastname = ?");
        query.setParameter(1,firstname);
        query.setParameter(2,surname);
        query.setParameter(3,lastName);
        return (Integer)query.getSingleResult();
    }
}
