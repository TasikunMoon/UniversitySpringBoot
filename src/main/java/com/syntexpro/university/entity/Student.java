package com.syntexpro.university.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter //for getter setter and to string code annotation
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor // for constructor
@Entity // for classs
@Table(name = "Students", schema = "university") // for table and scheme in database

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")

    @Column(name = "student_id", updatable = false) // table pattern ki hbe updatable na null mention korte hbe
    private Long id;
    //for first name and need to use before excess modifier code
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "Text" // table context er niche ki likha show korbe
    )
    private String firstName;
    //for last name and need to use before excess modifier code
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "Text")
    private String lastName;
    //for email address and need to use before excess modifier code
    @Column(
            name = "email_address",
            nullable = false,
            columnDefinition = "Text"

    )
    private String email;
    //for age and need to use before excess modifier code
    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

}
