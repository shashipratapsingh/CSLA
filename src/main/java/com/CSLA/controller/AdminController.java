package com.CSLA.controller;

import com.CSLA.entity.UploadDocs;
import com.CSLA.service.DocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PreAuthorize("hasAuthority('ROLE_Admin')")
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Admin Dashboard";
    }
    @Autowired
    private DocsService docsService;


    @PreAuthorize("hasAnyAuthority('ROLE_Admin')")
    @PostMapping("/")
    public ResponseEntity<UploadDocs> createCandidateDetails(
            @RequestPart("uploadDocs") UploadDocs uploadDocs,
            @RequestPart("docsFileFile") MultipartFile docsFileFile) throws IOException {
        UploadDocs savedCandidateDetails = docsService.saveUploadDocs(uploadDocs, docsFileFile);
        return ResponseEntity.ok(savedCandidateDetails);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_Admin', 'ROLE_Manager', 'ROLE_User')")
    public ResponseEntity<UploadDocs> getCandidateDetailsById(@PathVariable("id") int id) {
        UploadDocs candidateDetails = docsService.getUploadDocsById(id);
        if (candidateDetails != null) {
            return ResponseEntity.ok(candidateDetails);
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if candidate not found
        }
    }



}
