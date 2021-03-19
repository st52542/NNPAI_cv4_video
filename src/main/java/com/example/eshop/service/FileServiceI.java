package com.example.eshop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileServiceI implements FileService {
    @Override
    public String upload(MultipartFile image) {
        Path path = Paths.get("C:\\Users\\herci\\IdeaProjects\\eshop\\img\\" + image.getOriginalFilename());
        try {
            Files.copy(image.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image.getOriginalFilename();
    }
}
