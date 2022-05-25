package com.example.resumemaker.service;

import com.example.resumemaker.dto.request.CandidateRequest;
import com.example.resumemaker.dto.response.CandidateResponse;
import com.example.resumemaker.entity.Candidate;
import com.example.resumemaker.entity.CvFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CandicateService {

    public CandidateResponse findById(Long id);
    public List<CandidateResponse> getAll();
    public CandidateResponse addCandicate(CandidateRequest request) throws IOException;
    public CvFile addCv(Long id, MultipartFile file) throws  IOException;
    public CandidateResponse updateCandicate(CandidateRequest request, Long id);
    public Candidate remove(Long id);

}
