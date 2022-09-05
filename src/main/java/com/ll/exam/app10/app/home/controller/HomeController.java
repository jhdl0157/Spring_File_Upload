package com.ll.exam.app10.app.home.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @Value("${custom.genFileDirPath}")
    private String DIR_URL;
    @RequestMapping("/")
    public String main() {
        return "home/main";
    }

    @RequestMapping("/test/upload")
    public String getupload() {
        return "home/test/upload";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("img1") MultipartFile multipartFile) throws IOException {
        System.out.println("진입 성공");
        System.out.println(multipartFile.getOriginalFilename());
        multipartFile.transferTo(new File(DIR_URL+"/1.png"));
        return "home/main";
    }
}
