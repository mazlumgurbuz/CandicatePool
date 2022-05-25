package com.example.resumemaker.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CvFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] content;


    public CvFile(String fileName, byte[] content, String fileType) {
            this.fileName = fileName;
            this.content = content;
            this.fileType = fileType;
    }
}