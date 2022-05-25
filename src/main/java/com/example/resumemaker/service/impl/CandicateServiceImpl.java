package com.example.resumemaker.service.impl;

import com.example.resumemaker.dto.request.CandidateRequest;
import com.example.resumemaker.dto.response.CandidateResponse;
import com.example.resumemaker.entity.Candidate;
import com.example.resumemaker.entity.CvFile;
import com.example.resumemaker.repository.CandicateRepository;
import com.example.resumemaker.repository.FileRepository;
import com.example.resumemaker.service.CandicateService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandicateServiceImpl implements CandicateService {

    private final CandicateRepository candidateRepository;
    private final ModelMapper modelMapper;
    private final FileRepository fileRepository;


    @Override
    public CandidateResponse findById(Long id) {
        var candicate = modelMapper.map(candidateRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException()), CandidateResponse.class);
        return candicate;
    }

    @Override
    public List<CandidateResponse> getAll() {
        return candidateRepository.findAll()
                .stream().map(candidate -> modelMapper.map(candidate, CandidateResponse.class))
                .toList();
    }

    @Override
    public CandidateResponse addCandicate(CandidateRequest request) throws IOException {
        var create = modelMapper.map(request, Candidate.class);
        candidateRepository.save(create);
        return modelMapper.map(create, CandidateResponse.class);

    }
    @Override
    public CvFile addCv(Long id, MultipartFile file) throws IOException {
        var create = candidateRepository.findById(id);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        CvFile FileDB = new CvFile(fileName, file.getBytes(), file.getContentType());
        create.get().setData(FileDB);
        return fileRepository.save(FileDB);
    }


    @Override
    public CandidateResponse updateCandicate(CandidateRequest request, Long id) throws IllegalArgumentException {
        var updated = candidateRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        modelMapper.map(request, updated);
        return modelMapper.map(candidateRepository.saveAndFlush(updated), CandidateResponse.class);

    }

    @Override
    public Candidate remove(Long id) {
        var deleted = candidateRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        candidateRepository.deleteById(id);
        return deleted;
    }
}
