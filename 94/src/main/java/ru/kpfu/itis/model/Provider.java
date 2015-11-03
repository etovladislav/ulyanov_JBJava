package ru.kpfu.itis.model;

import javax.persistence.*;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @JoinColumn(name = "jur_info", nullable = false)
    @OneToOne
    private JurInfo jurInfo;

    @JoinColumn(name = "office_id", nullable = false)
    @ManyToOne
    private Office officeId;


}
