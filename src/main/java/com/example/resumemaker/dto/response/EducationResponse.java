package com.example.resumemaker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationResponse {
    private Long id;
    private String name;
    private String entry;
    private String leaving;
    private String department;
}
