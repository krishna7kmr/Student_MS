package com.nt.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {

    private UUID id;
    @Size(min = 2,message="Name must be at least 1 characters")
    private String name;
    @NotBlank(message = "Name is mandatory")
    private String dept;
    private String address;
}
