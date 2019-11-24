package com.changhr.cloud.securtiy.demo.web.controller;

import com.changhr.cloud.securtiy.demo.web.vo.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author changhr2013
 * @date 2019/11/24
 */
@RestController
@RequestMapping("/file")
public class FileController {

    String folder = "D:\\Users\\chang\\Github\\cloud-security\\cloud-security-demo\\src\\main\\resources\\upload";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File(folder, System.currentTimeMillis() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
        try (FileInputStream is = new FileInputStream(new File(folder, id + ".txt"));
             OutputStream os = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(is, os);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
