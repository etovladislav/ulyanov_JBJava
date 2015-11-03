package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "jur_info")
public class JurInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "sries", nullable = false)
    private String sries;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "unic_number_uuid", nullable = false)
    private String unicNumberUuid;

    public JurInfo() {
    }

    public JurInfo(String sries, String number, String unicNumberUuid) {
        this.sries = sries;
        this.number = number;
        this.unicNumberUuid = unicNumberUuid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSries() {
        return sries;
    }

    public void setSries(String sries) {
        this.sries = sries;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUnicNumberUuid() {
        return unicNumberUuid;
    }

    public void setUnicNumberUuid(String unicNumberUuid) {
        this.unicNumberUuid = unicNumberUuid;
    }
}
