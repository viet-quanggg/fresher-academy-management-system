package com.backend.FAMS;

import com.backend.FAMS.entity.Syllabus.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class SyllabusController  {
    SyllabusRepo syllabusRepo;
    @GetMapping("")
    public List<Syllabus> getAll(){
       return syllabusRepo.findAll();
    }
}
