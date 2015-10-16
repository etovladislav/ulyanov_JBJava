package ru.kpfu.itis.repository.iml;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.repository.ScoreRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;

@Repository
public class ScoreRepositoryImpl implements ScoreRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public BigDecimal getAverage(Integer id) {
        Query query = em.createNativeQuery("SELECT AVG(score) FROM scores WHERE student_id = ?");
        query.setParameter(1, id);
        return (BigDecimal) query.getSingleResult();
    }

    @Override
    public BigInteger getScore(Integer id) {
        Query query = em.createNativeQuery("SELECT SUM(score) FROM scores WHERE student_id = ?");
        query.setParameter(1, id);
        return (BigInteger) query.getSingleResult();
    }

    @Override
    public Integer getScoreSubject(Integer id, Integer subject) {
        Query query = null;
        try {
            query = em.createNativeQuery("SELECT score FROM scores WHERE student_id = ? and subject_type = ?");
            query.setParameter(1, id);
            query.setParameter(2, subject);
            return (Integer) query.getSingleResult();
        }catch (NoResultException nre){
            return null;
        }
    }
}
