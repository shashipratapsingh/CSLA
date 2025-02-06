package com.CSLA.repository;


import com.CSLA.entity.UploadDocs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocsRepository extends JpaRepository<UploadDocs, Integer> {
}
