package com.ll.exam.app10.fileupload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
    @Value("${custom.genWinFileDirPath}")
    private static String genWinFileDirPath;
    @Value("${custom.genMacFileDirPath}")
    private static  String genMacFileDirPath;

    @RequestMapping("")
    @ResponseBody
    public String upload(@RequestParam("img1") MultipartFile img1, @RequestParam("img2") MultipartFile img2) {
        try {
            img1.transferTo(new File(getOsInfo() + "/1.png"));
            img2.transferTo(new File(getOsInfo() + "/2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "업로드 완료!";
    }

    private static String getOsInfo(){
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return genWinFileDirPath;
        }
        return genMacFileDirPath;
    }
}
