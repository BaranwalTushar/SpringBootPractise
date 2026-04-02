package com.SpringDataJPA.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne// many  appointment have save patient
    @ToString.Exclude
    @JoinColumn(name = "patient_id" , nullable = false)// ptient is required  and not nullable and patient is owning for appointmnt
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)// so we didnt call doctor unnecessarily
    @ToString.Exclude
    @JoinColumn(nullable = false)
    private Doctor doctor;



}
