package ru.kpfu.itis.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.MedClinic;
import ru.kpfu.itis.model.Office;
import ru.kpfu.itis.model.Provider;
import ru.kpfu.itis.model.enums.PeopleType;
import ru.kpfu.itis.repository.MedClinicRepository;
import ru.kpfu.itis.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class MedClinicRepositoryImpl implements MedClinicRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    PersonRepository personRepository;

    @Override
    public Integer getOfficeId(Office office, MedClinic medClinic) {
        Query query = entityManager.createNativeQuery("SELECT o.id FROM office o WHERE o.city = ? " +
                "AND o.street = ? AND o.med_clinic_id = ?");
        query.setParameter(1, office.getCity());
        query.setParameter(2, office.getStreet());
        query.setParameter(3, medClinic.getId());
        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer getMedClinicId(MedClinic medClinic) {
        Query query = entityManager.createNativeQuery("SELECT id FROM med_clinic WHERE " +
                "licence_number = ? AND name = ?");
        query.setParameter(1, medClinic.getLicenceNumber());
        query.setParameter(2, medClinic.getName());
        return (Integer) query.getSingleResult();
    }


    @Override
    public Double getAverageSalary(List<Integer> persons) {
        if (persons.isEmpty()) {
            return null;
        }
        Double sumSalary = 0.0;
        for (Integer i : persons) {
            sumSalary += personRepository.getSalary(i);
        }
        return sumSalary / persons.size();
    }

    @Override
    public Double getAverageCheck(List<Integer> persons) {
        if (persons.isEmpty()) {
            return null;
        }
        Double sumSalary = 0.0;
        for (Integer i : persons) {
            sumSalary += personRepository.getCheck(i);
        }
        return sumSalary / persons.size();
    }

    @Override
    public List<Integer> getPerson(MedClinic medClinic, PeopleType peopleType) {
        Query query = entityManager.createNativeQuery("SELECT * FROM office" +
                " INNER JOIN med_clinic ON(med_clinic_id = office.med_clinic_id) " +
                "INNER JOIN people ON people.office_id = office.id " +
                "WHERE people.type = ? AND med_clinic.id = ?");
        query.setParameter(1, peopleType.ordinal());
        query.setParameter(2, medClinic.getId());
        return query.getResultList();
    }

    @Override
    public List<Integer> getPersonOffice(Integer medClinicId, PeopleType peopleType, Integer officeId) {
        Query query = entityManager.createNativeQuery("SELECT p.id FROM people p INNER JOIN office AS o ON(o.id = p.office_id ) " +
                "INNER JOIN med_clinic AS mc ON(mc.id = o.med_clinic_id) " +
                "WHERE p.type = ? AND mc.id = ? AND o.id = ?");
        query.setParameter(1, peopleType.ordinal());
        query.setParameter(2, medClinicId);
        query.setParameter(3, officeId);
        return query.getResultList();
    }

    @Override
    public List<Office> getOffice(Integer medClinicId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM office o INNER JOIN" +
                " med_clinic AS mc ON (mc.id = o.med_clinic_id) WHERE mc.id = ?");
        query.setParameter(1, medClinicId);
        return query.getResultList();
    }

    @Override
    public List<MedClinic> getClinics() {
        Query query = entityManager.createNativeQuery("SELECT * FROM med_clinic");
        return query.getResultList();
    }

    @Override
    public List<Date> getBeginDate(Provider provider, Integer officeId) {
        Query query = entityManager.createNativeQuery("SELECT os.begin_date from provider p " +
                " inner join office o on (o.id = p.office_id) " +
                " inner join operation_supplier AS os ON (os.provider_id = p.id) " +
                " where p.name = ? and o.id = ? and os.end_date is NULL");
        query.setParameter(1, provider.getName());
        query.setParameter(2, officeId);
        return query.getResultList();
    }

}
