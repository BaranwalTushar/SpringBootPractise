package com.SpringDataJPA.service;

import com.SpringDataJPA.entity.Patient;
import com.SpringDataJPA.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    @Autowired
    private  final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id ){
        Patient p1 = patientRepository.findById(id).orElseThrow();
        Patient p2  = patientRepository.findById(id).orElseThrow();

        System.out.println(p1 == p2);// True because of transaction
        p1.setName("Saurabh"); // this will update name without save() metho because of transaction.


        return  p1;



    }
}
