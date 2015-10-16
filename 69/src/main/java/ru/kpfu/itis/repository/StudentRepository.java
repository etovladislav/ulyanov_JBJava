package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Student;

/**
 * Created by Vladislav on 16.10.2015.
 */
public interface StudentRepository {
    public Integer findStudentByNameSurnameLasName(String firstname, String surname, String lastName);
}
