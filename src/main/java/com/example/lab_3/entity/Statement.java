package com.example.lab_3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="statements")
public class Statement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_entered")
    private Boolean isEntered;

    @OneToMany( targetEntity = Mark.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "statement_id",referencedColumnName = "id")
    private List<Mark> marks;

    @OneToOne(targetEntity = Abiturient.class, cascade = CascadeType.DETACH)
    @JoinColumn(name = "abiturient_id", referencedColumnName = "id")
    private Abiturient abiturient;

    @OneToOne
    private Administrator administrator;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    private Faculty faculty;

    @JsonIgnore
    public double getAverageMark() {
        double summ = 0;
        for (Mark mark : marks) {
            summ += mark.getMark();
        }
        return summ / marks.size();
    }

}
