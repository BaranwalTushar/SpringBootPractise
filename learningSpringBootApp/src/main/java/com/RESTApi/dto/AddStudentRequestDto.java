package com.RESTApi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class AddStudentRequestDto {

    @NotBlank(message = "Name is required..")
    @Size(min = 3, max = 30 , message = "Name should be a length of min 30 character")
    private String name;

    @Email
    @NotBlank(message = "Email is required..")
    private String email;
}
