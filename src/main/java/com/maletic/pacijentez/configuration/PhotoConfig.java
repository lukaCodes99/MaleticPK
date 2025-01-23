package com.maletic.pacijentez.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PhotoConfig implements WebMvcConfigurer {

    //ovo se koristi da bi mogli sa servera statički posluživati slike prema frontendu

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Photos-PacijentEZ/**")
                .addResourceLocations("file:///C:/Users/Luka/Desktop/Photos-PacijentEZ/");
    }

}