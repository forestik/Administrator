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
@Table(name="faculties")

public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private int size;

    @Column(name = "min_avarage")
    private int minAvarage;

    @OneToMany(mappedBy = "faculty",
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Abiturient> abiturients;

    @OneToOne
    private Administrator administrator;

    @OneToMany( targetEntity = Statement.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id",referencedColumnName = "id")
    @JsonIgnore
    private List<Statement> statements;

}
