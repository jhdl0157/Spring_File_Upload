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
    @Value("${custom.genFileDirPath}")
    private  String DIR_URL;

    @Value("${custom.genMac}")
    private  String MAC_DIR_URL;


    @RequestMapping("")
    @ResponseBody
    public String upload(@RequestParam("img1") MultipartFile img1, @RequestParam("img2") MultipartFile img2) {
        try {
            System.out.println(getOsDir());
            img1.transferTo(new File(getOsDir()+"/1.png"));
            img2.transferTo(new File(getOsDir() + "/2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "업로드 완료!";
    }

    public  String getOsDir(){
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            System.out.println("This is Windows");
            return DIR_URL;
        } else if (osName.contains("mac")) {
            System.out.println("This is Mac");
            return MAC_DIR_URL;
        }
        return null;
    }


}
