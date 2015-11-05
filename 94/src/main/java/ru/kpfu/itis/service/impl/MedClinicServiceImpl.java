package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.MedClinic;
import ru.kpfu.itis.model.Office;
import ru.kpfu.itis.model.Provider;
import ru.kpfu.itis.model.enums.PeopleType;
import ru.kpfu.itis.repository.MedClinicRepository;
import ru.kpfu.itis.service.MedClinicService;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;

@Service
public class MedClinicServiceImpl implements MedClinicService {

    @Autowired
    MedClinicRepository medClinicRepository;


    @Override
    public Integer getBestOffice(MedClinic medClinic) {
        Integer medClinicId = medClinicRepository.getMedClinicId(medClinic);
        List<Office> offices = medClinicRepository.getOffice(medClinicId);
        Double max = 0.0;
        Double val = 0.0;
        Integer idBestOffice = null;
        for (Office office : offices) {
            val = getAverageCheck(medClinic, office);
            if (val > max) {
                max = val;
                idBestOffice = office.getId();
            }
        }
        return idBestOffice;
    }

    @Override
    public Integer getBestMedClinic() {
        List<MedClinic> medClinics = medClinicRepository.getClinics();
        Double max = 0.0;
        Double val = 0.0;
        Integer bestClinicsId = null;
        for (MedClinic medClinic : medClinics) {
            val = getSumOfficeCheck(medClinic);
            if (val > max) {
                bestClinicsId = medClinic.getId();
                max = val;
            }
        }
        return bestClinicsId;
    }

    @Override
    public Double getSalary(MedClinic medClinic) {
        Integer medClinicId = medClinicRepository.getMedClinicId(medClinic);
        return medClinicRepository.getAverageSalary(medClinicRepository.getPerson(medClinic, PeopleType.WORKER));
    }

    @Override
    public Double getAverageCheck(MedClinic medClinic, Office office) {
        try {
            Integer medClinicId = medClinicRepository.getMedClinicId(medClinic);
            List<Integer> person = medClinicRepository.getPersonOffice(
                    medClinicId, PeopleType.CLIENT, medClinicRepository.getOfficeId(office, medClinic));
            return medClinicRepository.getAverageCheck(person);
        } catch (NoResultException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Double getSumOfficeCheck(MedClinic medClinic) {
        Double sum = 0.0;
        List<Office> offices = medClinicRepository.getOffice(medClinic.getId());
        for (Office office : offices) {
            sum += medClinicRepository.getAverageCheck(medClinicRepository.getPersonOffice(medClinic.getId(), PeopleType.CLIENT, office.getId()));
        }
        return sum;
    }

    @Override
    public Date getLastSending(MedClinic medClinic, Provider provider) {
        Integer medClinicId = medClinicRepository.getMedClinicId(medClinic);
        List<Office> offices = medClinicRepository.getOffice(medClinicId);
        for (Office office : offices) {
            List<Date> dates = medClinicRepository.getBeginDate(provider, office.getId());
            if (dates.size() == 0) {
                return null;
            }
            return dates.get(0);
        }
        return null;
    }
}
