package com.CSLA.service;

import com.CSLA.entity.UploadDocs;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DocsService {

    UploadDocs saveUploadDocs(UploadDocs uploadDocs, MultipartFile docsFileFile) throws IOException;
    //CandidateDetails getCandidateDetailsById(int id);
}
