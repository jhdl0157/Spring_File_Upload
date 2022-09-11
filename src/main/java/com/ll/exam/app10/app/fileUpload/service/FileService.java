package com.ll.exam.app10.app.fileUpload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface FileService {
    List<String> fileUpload(List<MultipartFile> multipartFiles);
}
