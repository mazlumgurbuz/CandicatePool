package com.example.resumemaker.repository;


import com.example.resumemaker.entity.CvFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<CvFile,Long> {

}
