package com.SpringDataJPA.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // it is a way to creating object we dont need to remember for which constructore i have to use which new keyword
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String policyNumber;

    @Column(nullable = false,length = 100)
    private String provider;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDate validUntil;

    @OneToOne(mappedBy = "insurance")// this is a inverse side // mapped by is using to remove ambiguity and this concept known as owning side and inverse side.
    private  Patient patient;
}
