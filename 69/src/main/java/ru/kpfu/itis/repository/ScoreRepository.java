package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Scores;
import ru.kpfu.itis.model.Student;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by Vladislav on 14.10.2015.
 */
public interface ScoreRepository {
    public BigDecimal getAverage(Integer id);
    public BigInteger getScore(Integer id);
    public Integer getScoreSubject(Integer id, Integer subject);
}
