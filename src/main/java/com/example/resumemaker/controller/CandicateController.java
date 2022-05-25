package com.example.resumemaker.controller;

import com.example.resumemaker.dto.request.CandidateRequest;
import com.example.resumemaker.dto.response.CandidateResponse;
import com.example.resumemaker.entity.Candidate;
import com.example.resumemaker.entity.CvFile;
import com.example.resumemaker.repository.FileRepository;
import com.example.resumemaker.service.CandicateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/candicate")
@RequestScope
@CrossOrigin
@RequiredArgsConstructor
public class CandicateController {

    private final CandicateService candicateService;
    private final FileRepository fileRepository;

    @GetMapping(value = "/{id}")
    public CandidateResponse findById(@PathVariable Long id){
        return candicateService.findById(id);
    }
    @GetMapping(value = "/getAll")
    public List<CandidateResponse> getAll(){
        return candicateService.getAll();
    }
    @PostMapping("/addCandidate")
    public CandidateResponse createCandicate(@RequestBody CandidateRequest request) throws IOException {
        return candicateService.addCandicate(request);
    }
    @RequestMapping(path = "/addCv", method = POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public CvFile addCv(@ModelAttribute("id") Long id, @RequestPart("file") MultipartFile file) throws IOException {
        return candicateService.addCv(id,file);
    }
    @DeleteMapping(value = "{id}")
    public Candidate deleteCandicate(@PathVariable Long id){
        return candicateService.remove(id);
    }
    @PutMapping(value = "{id}")
    public CandidateResponse updateCandicate(@PathVariable Long id , @RequestBody CandidateRequest request){
        return candicateService.updateCandicate(request,id);
    }
}
