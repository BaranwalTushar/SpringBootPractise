package com.SpringDataJPA.service;

import com.SpringDataJPA.entity.Appointment;
import com.SpringDataJPA.entity.Doctor;
import com.SpringDataJPA.entity.Patient;
import com.SpringDataJPA.repository.AppointmentRepository;
import com.SpringDataJPA.repository.DoctorRepository;
import com.SpringDataJPA.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private  final PatientRepository patientRepository;

    @Transactional
    public  Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId()!=null) throw  new IllegalArgumentException("Appointment sould have an ID while creating a new record");


        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);// to maintain bidirectional consistency.

       return appointmentRepository.save(appointment);

    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);// this will automatically call the update . because its dirty
        doctor.getAppointments().add(appointment);// just for bidirectional.


        return appointment;



    }


}
