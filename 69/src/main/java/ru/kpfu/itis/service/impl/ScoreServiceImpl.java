package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.repository.ScoreRepository;
import ru.kpfu.itis.repository.StudentRepository;
import ru.kpfu.itis.service.ScoreService;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Vladislav on 14.10.2015.
 */
@Service
public class ScoreServiceImpl implements ScoreService {


    @Autowired
    ScoreRepository userRepository;

    @Autowired
    StudentRepository studentRepository;

    public Integer findStudent(Student student) {
        return studentRepository.findStudentByNameSurnameLasName(student.getFirstName(), student.getSurName(), student.getLastName());
    }

    @Override
    public BigDecimal getAverage(Student student) {
        return userRepository.getAverage(findStudent(student));
    }

    @Override
    public BigInteger getScore(Student student) {
        return userRepository.getScore(findStudent(student));
    }

    @Override
    public Integer getScoreSubject(Student student, Integer subject) {
        return userRepository.getScoreSubject(findStudent(student), subject);
    }
}
