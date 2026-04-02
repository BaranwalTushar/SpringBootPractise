package com.RESTApi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor // this will generate constructor of all automatic
@NoArgsConstructor // default constructor with no parameter
public class StudentDto {
    private int id;
    private String name;
    private String email;


}
