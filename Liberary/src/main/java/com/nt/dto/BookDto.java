package com.nt.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Setter
@Getter
@Data
public class BookDto {

    private UUID id;
    private String name;
    private String description;
    private int rentCost;
    private int noOfDays;
}
