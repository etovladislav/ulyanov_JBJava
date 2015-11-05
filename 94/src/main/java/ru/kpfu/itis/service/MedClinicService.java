package ru.kpfu.itis.service;


import ru.kpfu.itis.model.MedClinic;
import ru.kpfu.itis.model.Office;
import ru.kpfu.itis.model.Provider;

import java.util.Date;

public interface MedClinicService {

    public Integer getBestOffice(MedClinic medClinic);

    public Integer getBestMedClinic();

    Double getSalary(MedClinic medClinic);

    Double getAverageCheck(MedClinic medClinic, Office office);

    Double getSumOfficeCheck(MedClinic medClinic);

    Date getLastSending(MedClinic medClinic, Provider provider);

}
