package com.coffee_backend.controller;

import cn.hutool.core.lang.UUID;
import com.coffee_backend.dto.ApiResponse;
import com.coffee_backend.dto.ArticleRequest;
import com.coffee_backend.dto.FileResponse;
import com.coffee_backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ApiResponse list(){
        return articleService.list();
    }

    @PostMapping
    public ApiResponse save(@RequestBody ArticleRequest articleRequest){
        return articleService.save(articleRequest);
    }

    @PutMapping("/{id}")
    public ApiResponse update(@PathVariable Long id, @RequestBody ArticleRequest articleRequest){
        return articleService.update(id, articleRequest);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Long id){
        return articleService.deleteById(id);
    }

    @PostMapping("/images/upload")
    public ApiResponse uploadImage(@RequestParam("image") MultipartFile file, @RequestParam(defaultValue = "COVER") String type, @RequestParam(required = false) String alt){

        String rootDir = "uploads";

        if (file.isEmpty()){
            return ApiResponse.error(404, "File can not be null");
        }
        // uploads/COVER
        String path = rootDir + "/" + type;

        File folder = new File(path);
        if (!folder.exists()){
            folder.mkdirs();
        }

        String originalFilename = file.getOriginalFilename();
        String fileExtensionName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + fileExtensionName;

        File newUploadFile = new File(folder, newFileName);
        try {
            file.transferTo(newUploadFile);
        } catch (IOException e) {
            return ApiResponse.error(404, "File can not be saved");
        }

        String baseUrl = "https://starbucks.zhangbh.com";
        String fileUrl = baseUrl + "/" + rootDir + "/" + type + "/" + newFileName;

        FileResponse fileResponse = FileResponse.builder().url(fileUrl).type(type).build();

        return ApiResponse.success(fileResponse);
    }


    @GetMapping("/{id}")
    public ApiResponse findById(@PathVariable Long id){
        return articleService.findById(id);
    }
}
