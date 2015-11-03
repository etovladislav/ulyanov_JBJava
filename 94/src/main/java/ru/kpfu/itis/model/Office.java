package ru.kpfu.itis.model;

import javax.persistence.*;

@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @JoinColumn(name = "med_clinic_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MedClinic medClinicId;


    public Office() {
    }

    public Office(String city, String street, MedClinic medClinicId) {
        this.city = city;
        this.street = street;
        this.medClinicId = medClinicId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public MedClinic getMedClinicId() {
        return medClinicId;
    }

    public void setMedClinicId(MedClinic medClinicId) {
        this.medClinicId = medClinicId;
    }
}
