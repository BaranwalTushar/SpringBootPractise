package com.SpringDataJPA.entity;

import com.SpringDataJPA.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString // this will autogenerate toString Method
@Getter
@Setter
@Table(name = "patient",
        indexes = {
           @Index(name = "idx_patient_birth_date", columnList = "birth_date")
        }

)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column( nullable = false)
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    @ToString.Exclude // i dont want to show this gender in console so it will exclude
    private String gender;

    @CreationTimestamp
    @Column(updatable = false)// it wil not update in future time stamp kbhi update ni ho sakta
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)// by defailt it store in the from of no. but i want to store in string so thats why
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true) //uni directional mapping ... orphan removal means i want to remove insurance but not patient.patient is parent and insurance is child so child will deletee automatic
    @JoinColumn(name = "patient_insurance_id")// owning side.
    private Insurance insurance;

    @OneToMany(mappedBy = "patient" , cascade = {CascadeType.REMOVE},orphanRemoval = true, fetch = FetchType.EAGER
    ) // inversed side is always be mapped.

    private List<Appointment> appointments = new ArrayList<>();



}
