package com.example.resumemaker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileResponse {

        private String fileName;
        private String fileDownloadUri;
        private String fileType;
        private long size;
}
