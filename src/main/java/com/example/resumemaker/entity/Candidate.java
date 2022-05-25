package com.example.resumemaker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
    private String phone;
    @Enumerated
    private Gender gender;
    private String email;
    private String abilities;
    @Enumerated
    private LatestEducationState latestEducationState = LatestEducationState.PASIVE;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "exper_id")
    @JsonIgnore
    private List<Experience> experience;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "education_id")
    private List<Education> education;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    @JsonIgnore
    private List<Language> foreingLanguages;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private CvFile data;

}
