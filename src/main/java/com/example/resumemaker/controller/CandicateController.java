package com.example.resumemaker.controller;

import com.example.resumemaker.dto.request.CandicateRequest;
import com.example.resumemaker.dto.response.CandicateResponse;
import com.example.resumemaker.dto.response.UploadFileResponse;
import com.example.resumemaker.entity.Candicate;
import com.example.resumemaker.entity.CvFile;
import com.example.resumemaker.repository.FileRepository;
import com.example.resumemaker.service.CandicateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    public CandicateResponse findById(@PathVariable Long id){
        return candicateService.findById(id);
    }
    @GetMapping(value = "/getAll")
    public List<CandicateResponse> getAll(){
        return candicateService.getAll();
    }

    @RequestMapping(path = "/addCandicate", method = POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CandicateResponse createCandicate(@Valid  @RequestParam CandicateRequest request, @RequestPart("file") MultipartFile file) throws IOException {
        return candicateService.addCandicate(request,file);
    }
    @DeleteMapping(value = "{id}")
    public Candicate deleteCandicate(@PathVariable Long id){
        return candicateService.remove(id);
    }
    @PutMapping(value = "{id}")
    public CandicateResponse updateCandicate(@PathVariable Long id ,@RequestBody CandicateRequest request){
        return candicateService.updateCandicate(request,id);
    }
}
