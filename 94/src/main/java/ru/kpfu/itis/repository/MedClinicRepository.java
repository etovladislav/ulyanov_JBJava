package ru.kpfu.itis.repository;


import ru.kpfu.itis.model.MedClinic;
import ru.kpfu.itis.model.Office;
import ru.kpfu.itis.model.Provider;
import ru.kpfu.itis.model.enums.PeopleType;

import java.util.Date;
import java.util.List;

public interface MedClinicRepository {

    Integer getOfficeId(Office office, MedClinic medClinic);

    Integer getMedClinicId(MedClinic medClinic);

    Double getAverageSalary(List<Integer> persons);

    Double getAverageCheck(List<Integer> persons);

    List<Integer> getPerson(MedClinic medClinic, PeopleType peopleType);

    List<Integer> getPersonOffice(Integer medClinicId, PeopleType peopleType, Integer officeId);

    List<Office> getOffice(Integer medClinicId);

    List<MedClinic> getClinics();

    List<Date> getBeginDate(Provider provider, Integer officeId);

}
