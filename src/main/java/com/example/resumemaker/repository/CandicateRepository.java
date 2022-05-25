package com.example.resumemaker.repository;

import com.example.resumemaker.entity.Candicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandicateRepository extends JpaRepository<Candicate,Long> {
}
