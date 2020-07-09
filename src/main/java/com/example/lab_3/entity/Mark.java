package com.example.lab_3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="marks")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private Subject name;
    @Column(name = "mark")
    private Integer mark;

//    private Long abiturientId;

    @ManyToOne(targetEntity = Abiturient.class, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "abiturient_id", referencedColumnName = "id")
    @JsonIgnore
    private Abiturient abiturient;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "statement_id", referencedColumnName = "id")
    @JsonIgnore
    private Statement statement;
}
