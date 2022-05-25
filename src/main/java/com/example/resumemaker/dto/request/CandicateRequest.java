package com.example.resumemaker.dto.request;

import com.example.resumemaker.entity.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandicateRequest {
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
    private String phone;
    private Gender gender;
    private String email;
    private String abilities;
    private LatestEducationState latestEducationState = LatestEducationState.PASIVE;
    private List<ExperienceRequest> experience;
    private List<EducationRequest> education;
    private List<LanguageRequest> foreingLanguages;
    private CvFile data;
}
