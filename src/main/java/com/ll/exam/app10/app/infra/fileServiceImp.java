package com.ll.exam.app10.app.infra;

import com.ll.exam.app10.app.fileUpload.repository.GenFileRepository;
import com.ll.exam.app10.app.fileUpload.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class fileServiceImp implements FileService {
    private final GenFileRepository genFileRepository;

    @Value("${custom.genFileDirPath}")
    private String genFileDirPath;

    @Override
    public List<String> fileUpload(List<MultipartFile> multipartFiles) {
        List<String> pathList=new ArrayList<>();
        multipartFiles.forEach(x -> {
                    try {
                        String originalName=x.getOriginalFilename();
                        String ext = originalName.substring(originalName.lastIndexOf('.'));
                        String resultPath=genFileDirPath + "/"+getUuid()+ext;
                        pathList.add(resultPath);
                        x.transferTo(new File(resultPath));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        return pathList;
    }

    private static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
