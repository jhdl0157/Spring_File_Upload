package com.ll.exam.app10.app.fileUpload.controller;

import com.ll.exam.app10.app.fileUpload.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/upload")
@RequiredArgsConstructor
public class FileUploadController {
    private final FileService fileService;
    @Value("${custom.genFileDirPath}")
    private String genFileDirPath;

    @PostMapping("")
    @ResponseBody
    public String upload(@RequestParam("img1") MultipartFile img1, @RequestParam("img2") MultipartFile img2) {
        List<MultipartFile> multipartFileList=new ArrayList<>();
        multipartFileList.add(img1);
        multipartFileList.add(img2);
        fileService.fileUpload(multipartFileList);
        return "업로드 완료!";
    }
}
