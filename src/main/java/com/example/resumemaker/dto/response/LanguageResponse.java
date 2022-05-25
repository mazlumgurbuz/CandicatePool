package com.example.resumemaker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageResponse {
    private Long Id;
    private String name;
    private String abilities;
}
