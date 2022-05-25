package com.example.resumemaker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceResponse {
    private Long id;
    private String companyName;
    private String mission;
    private String department;
    private String entry;
    private String leaving;

}
