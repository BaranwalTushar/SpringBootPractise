package com.SpringDataJPA;

import com.SpringDataJPA.entity.Appointment;
import com.SpringDataJPA.entity.Insurance;
import com.SpringDataJPA.entity.Patient;
import com.SpringDataJPA.repository.PatientRepository;
import com.SpringDataJPA.service.AppointmentService;
import com.SpringDataJPA.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceAppointmentTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientRepository patientRepository;


    @Test
    public  void testInsurance(){
        Insurance insurance = Insurance.builder().policyNumber("HDFC_1234").provider("HDFC").validUntil(
                LocalDate.of(2030,12,12)).build();

       Patient patient =  insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

        var newPatient = insuranceService.disassociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);

    }

    @Test
    public void testCreateAppointment(){

        Appointment appointment = Appointment.builder().appointmentTime(LocalDateTime.of(2025,11,1,14,0))
                .reason("Cancer").build();

        var newAppointment = appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(newAppointment);

       var updatedAppointment =  appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(),2L);
        System.out.println(updatedAppointment);
    }

    @Test
    public void testCreateDelete(){
        for(int i =1;i<=3;i++){
            Appointment appointment = Appointment
                    .builder().appointmentTime(LocalDateTime.of(2025,11,i,10,0))
                    .reason("visit "+i).build();
            appointmentService.createNewAppointment(appointment,2L,3L);
        }
        System.out.println("appointment created..");

        patientRepository.deleteById(3L);
        System.out.println("Patient Deleted....");


    }
}
