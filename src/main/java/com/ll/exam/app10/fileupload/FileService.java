package com.ll.exam.app10.fileupload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static com.ll.exam.app10.fileupload.controller.FileUploadController.getOsDir;

@Service
public class FileService {
    public String fileUpload(MultipartFile multipartFile){
        String originalName=multipartFile.getOriginalFilename();
        final String ext = originalName.substring(originalName.lastIndexOf('.'));
        final String saveFileName = getUuid() + ext;
        try {
            System.out.println(getOsDir());
            multipartFile.transferTo(new File(getOsDir()+"/"+saveFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return saveFileName;

    }
    private static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
