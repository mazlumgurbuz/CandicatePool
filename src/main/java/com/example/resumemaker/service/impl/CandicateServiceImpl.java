package com.example.resumemaker.service.impl;

import com.example.resumemaker.dto.request.CandicateRequest;
import com.example.resumemaker.dto.request.CvFileRequest;
import com.example.resumemaker.dto.response.CandicateResponse;
import com.example.resumemaker.entity.Candicate;
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
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.random.RandomGenerator;

@Service
@RequiredArgsConstructor
public class CandicateServiceImpl implements CandicateService {

    private final CandicateRepository candicateRepository;
    private final ModelMapper modelMapper;
    private final FileRepository fileRepository;


    @Override
    public CandicateResponse findById(Long id) {
        var candicate = modelMapper.map(candicateRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException()), CandicateResponse.class);
        return candicate;
    }

    @Override
    public List<CandicateResponse> getAll() {
        return candicateRepository.findAll()
                .stream().map(candicate -> modelMapper.map(candicate, CandicateResponse.class))
                .toList();
    }

    @Override
    public CandicateResponse addCandicate(CandicateRequest request, MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        CvFile FileDB = new CvFile(fileName, file.getBytes(), file.getContentType());
        request.setData(FileDB);
        System.out.println(request.getData().getId());
        System.out.println(request.getData().getFileName());
        System.out.println(request.getData().getFileType());
        System.out.println(request.getData().getContent());

        var create = modelMapper.map(request, Candicate.class);
        candicateRepository.save(create);
        return modelMapper.map(create, CandicateResponse.class);

    }


    @Override
    public CandicateResponse updateCandicate(CandicateRequest request, Long id) throws IllegalArgumentException {
        var updated = candicateRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        modelMapper.map(request, updated);
        return modelMapper.map(candicateRepository.saveAndFlush(updated), CandicateResponse.class);

    }

    @Override
    public Candicate remove(Long id) {
        var deleted = candicateRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        candicateRepository.deleteById(id);
        return deleted;
    }
}
