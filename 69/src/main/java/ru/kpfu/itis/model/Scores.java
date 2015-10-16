package ru.kpfu.itis.model;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Scores {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genScores")
    @SequenceGenerator(sequenceName = "scores_id_seq", name = "genScores")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "subject_type", nullable = false)
    private Subject subjectType;

    @Column(name = "score")
    private Integer score;

    @JoinColumn(name = "student_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student studentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subject getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Subject subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }
}
