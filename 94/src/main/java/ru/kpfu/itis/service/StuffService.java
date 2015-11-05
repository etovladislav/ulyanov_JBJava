package ru.kpfu.itis.service;

import ru.kpfu.itis.model.People;

import java.util.Date;


public interface StuffService {

    Double getStuffSalary(People people);

    Date getEmployedDate(People people);
}
