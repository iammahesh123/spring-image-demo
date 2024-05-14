package org.example.springimagedemo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ImageController {

    @GetMapping("/image")
    public ResponseEntity<byte[]> getImage() throws IOException {
        // Load image data
        ClassPathResource resource = new ClassPathResource("static/images/image.png");
        byte[] imageData = Files.readAllBytes(resource.getFile().toPath());

        // Set content type header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        // Return image data as ResponseEntity
        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }
}
