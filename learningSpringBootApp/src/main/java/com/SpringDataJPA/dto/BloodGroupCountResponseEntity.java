package com.SpringDataJPA.dto;

import com.SpringDataJPA.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BloodGroupCountResponseEntity {
    private BloodGroupType bloodGroupType;
    private  Long count;
}
