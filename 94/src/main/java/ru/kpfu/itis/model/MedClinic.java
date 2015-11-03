package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "med_clinic")
public class MedClinic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creatin_date")
    private Date creatinDate;

    @Column(name = "licence_number")
    private long licenceNumber;

    public MedClinic() {
    }

    public MedClinic(String name, Date creatinDate, long licenceNumber) {
        this.name = name;
        this.creatinDate = creatinDate;
        this.licenceNumber = licenceNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatinDate() {
        return creatinDate;
    }

    public void setCreatinDate(Date creatinDate) {
        this.creatinDate = creatinDate;
    }

    public long getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(long licenceNumber) {
        this.licenceNumber = licenceNumber;
    }
}
