package com.example.resumemaker.service;

import com.example.resumemaker.dto.request.CandicateRequest;
import com.example.resumemaker.dto.request.CvFileRequest;
import com.example.resumemaker.dto.response.CandicateResponse;
import com.example.resumemaker.dto.response.CvFileResponse;
import com.example.resumemaker.entity.Candicate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CandicateService {

    public CandicateResponse findById(Long id);
    public List<CandicateResponse> getAll();
    public CandicateResponse addCandicate(CandicateRequest request,MultipartFile file ) throws IOException;
    public CandicateResponse updateCandicate(CandicateRequest request,Long id);
    public Candicate remove(Long id);

}
