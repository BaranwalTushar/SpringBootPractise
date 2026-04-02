package com.SpringDataJPA;

import com.SpringDataJPA.dto.BloodGroupCountResponseEntity;
import com.SpringDataJPA.entity.Patient;
import com.SpringDataJPA.repository.PatientRepository;
import com.SpringDataJPA.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public  void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);
//
//        Patient p1  = new Patient();
//        patientRepository.save(p1);
    }

    // Below are all the concept of JPA Query  method and using all methods referred  to this url (https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html)
    @Test
    public  void  testTransactionMethods(){
//        Patient patient = patientService.getPatientById(1L);
       // Patient patient = patientRepository.findById(1L).orElseThrow(()-> new EntityNotFoundException("Patient not found with id  1"));
        //Patient patient = patientRepository.findByName("Ankit");
        //System.out.println(patient);


//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(2000,05,15),"tushar@gmail.com");

      //  List<Patient> patientList = patientRepository.findByNameContaining("i");

      //  List<Patient> patientList = patientRepository.findByGender("Male");

//        List<Patient> patientList = patientRepository.findByAfterDate(LocalDate.of(2000,07,25));

//        List<Patient> patientList = patientRepository.findAllPatient();
        Page<Patient> patientList = patientRepository.findAllPatient( PageRequest.of(1,2, Sort.by("name")));

        for (Patient patient : patientList){
            System.out.println(patient);
        }

//        List<Object[]> gender = patientRepository.countEachGender();
//        for(Object[] objects : gender){
//            System.out.println(objects[0] + " "+ objects[1]);
//        }


//        int rowsUpdated = patientRepository.updateNameWithId("Tushar Keshri", 46L);
//        System.out.println(rowsUpdated);

        //ye blood group wala database m ni hai isliye ye concept bs sikhne k liye kaise gende ko count karenge groupby m karke repository m comment kiye hai this concept known dto projection

//               List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponseEntity : bloodGroupList){
//            System.out.println(bloodGroupCountResponseEntity);
//        }




    }
}
