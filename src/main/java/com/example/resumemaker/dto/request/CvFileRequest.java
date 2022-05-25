package com.example.resumemaker.dto.request;

import com.example.resumemaker.entity.Gender;
import com.example.resumemaker.entity.LatestEducationState;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CvFileRequest {
    private Long id;
    private String fileName;
    private String fileType;
    private byte[] content;
}
