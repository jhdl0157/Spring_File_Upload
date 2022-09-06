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
    @RequestMapping("/")
    public String main() {
        return "home/main";
    }

    @RequestMapping("/test/upload")
    public String getupload() {
        return "home/test/upload";
    }
}
