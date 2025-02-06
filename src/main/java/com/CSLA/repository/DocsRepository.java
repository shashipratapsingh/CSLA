package com.CSLA.repository;


import com.CSLA.entity.UploadDocs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocsRepository extends JpaRepository<UploadDocs, Integer> {
    List<UploadDocs> findByStatus(String status); // Correct method to find by status
}

