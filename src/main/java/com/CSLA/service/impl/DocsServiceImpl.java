package com.CSLA.service.impl;

import com.CSLA.entity.UploadDocs;
import com.CSLA.repository.DocsRepository;
import com.CSLA.service.DocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class DocsServiceImpl implements DocsService {

    @Autowired
    private DocsRepository docsRepository;

    @Value("${file.upload-dir}") // From application.properties
    private String uploadDir;

    public UploadDocs saveUploadDocs(UploadDocs uploadDocs, MultipartFile docsFileFile) throws IOException {

        // Generate a unique filename
        String fileName = docsFileFile.getOriginalFilename();

        // Ensure the directory exists
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Define the path where the file will be saved
        File filePath = new File(uploadDir + "/" + fileName);

        // Save the file to the specified location
        docsFileFile.transferTo(filePath);

        // Set the file name and URL in the candidateDetails entity
        uploadDocs.setDocsCardFileName(fileName);
        uploadDocs.setDocsFilePath("/documents/" + fileName);  // Assuming the images are served from this path
        return docsRepository.save(uploadDocs);
    }

    @Override
    public UploadDocs getUploadDocsById(int id) {
        Optional<UploadDocs> uploadDocsOptional = docsRepository.findById(id);
        return uploadDocsOptional.orElse(null); // Return null if not found
    }
}
