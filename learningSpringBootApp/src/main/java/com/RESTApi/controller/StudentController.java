package com.RESTApi.controller;

import com.RESTApi.dto.AddStudentRequestDto;
import com.RESTApi.dto.StudentDto;
import com.RESTApi.entity.Student;
import com.RESTApi.repository.StudentRepository;
import com.RESTApi.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // it will automatic converyt in json
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents()) ;
    }

    @GetMapping("/{id}")
    public  ResponseEntity<StudentDto> getStudentById(@PathVariable Long id ){
        return ResponseEntity.ok( studentService.getStudentById(id));
    }


    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id ){

        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable @Valid Long id,
                                                    @RequestBody AddStudentRequestDto addStudentRequestDto ){

        return  ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));

    }

    @PatchMapping("/{id}")
    public  ResponseEntity<StudentDto> updatePartialStudent(@PathVariable @Valid Long id,
                                                            @RequestBody Map<String, Object> updates){
        return  ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }



}
