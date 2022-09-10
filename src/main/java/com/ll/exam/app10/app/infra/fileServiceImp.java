package com.ll.exam.app10.app.infra;

import com.ll.exam.app10.app.fileUpload.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class fileServiceImp implements FileService {
    @Override
    public List<String> fileUpload(List<MultipartFile> multipartFiles) {
        return null;
    }
}
