package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Student;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Vladislav on 14.10.2015.
 */
public interface ScoreService {
    public BigDecimal getAverage(Student student);
    public BigInteger getScore(Student student);
    public Integer getScoreSubject(Student student, Integer subject);
}
