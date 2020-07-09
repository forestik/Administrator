package com.example.lab_3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="abiturients")
public class Abiturient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany( targetEntity = Mark.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "abiturient_id",referencedColumnName = "id")
    private List<Mark> marks;


    @OneToOne(targetEntity = Statement.class, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "statement_id", referencedColumnName = "id")
    @JsonIgnore
    private Statement statement;

}
