package com.example.resumemaker.repository;

import com.example.resumemaker.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandicateRepository extends JpaRepository<Candidate,Long> {
}
