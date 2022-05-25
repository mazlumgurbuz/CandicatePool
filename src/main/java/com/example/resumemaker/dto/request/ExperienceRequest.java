package com.example.resumemaker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceRequest {
    private Long id;
    private String companyName;
    private String mission;
    private String department;
    private String entry;
    private String leaving;
}
