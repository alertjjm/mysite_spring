package com.example.mysite.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String uploadImagesPath="C:/Users/windows10/Desktop/mysite/mysitestorage/";
        registry.addResourceHandler("/image/**").addResourceLocations("file:///"+uploadImagesPath);
    }
}
