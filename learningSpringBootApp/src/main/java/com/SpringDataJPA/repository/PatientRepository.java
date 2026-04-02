package com.SpringDataJPA.repository;


import com.SpringDataJPA.dto.BloodGroupCountResponseEntity;
import com.SpringDataJPA.entity.Patient;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.Parent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient,Long> {

    Patient findByName(String name);
   List<Patient>  findByBirthDateOrEmail(LocalDate birthDate, String email);
   List<Patient> findByNameContaining(String query);

   //below are Jpa Query

   @Query("SELECT p From Patient p where p.gender = ?1")
    List<Patient> findByGender(@Param("gender") String gender);

   @Query("SELECT p from Patient p where p.birthDate > :birthDate")
   List<Patient> findByAfterDate(@Param("birthDate") LocalDate birthDate);

   @Query("SELECT p.gender , Count(p) from Patient p group by p.gender")
   List<Object[]> countEachGender();


   //mere pass bloodgroup databasenhi tha isliye mai bs learn kiya ye concept use kaise karte hai dto pakckage mai entity bnake phir uska path copy karte hai
//    @Query("SELECT new com.SpringDataJPA.dto.BloodGroupCountResponseEntity(p.bloodGroupType, Count(p))"
//            + " from Patient p group by p.bloodGroupType")
//    List<BloodGroupCountResponseEntity> countEachBloodGroupType();


//   this are native query like SQL query
   @Query(value = "select * from patient", nativeQuery = true)
 //  List<Patient> findAllPatient();
//   if i want pagination
   Page<Patient> findAllPatient(Pageable pageable);

   @Transactional
   @Modifying
   @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name")String name, @Param("id")Long id);

   //@Query("SELECT p from Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor") //// when in appointment.java we use fetch eager so we need to define join for fetch doctor.
   @Query("SELECT p from Patient p LEFT JOIN FETCH p.appointments ")// but whwn we use Lazy fetch so we dont need to define join for doctor because we dont need doctor for this query . i just need 5 different appointment for 5 patient
   List<Patient> findAllPatientWithAppointment();
}
