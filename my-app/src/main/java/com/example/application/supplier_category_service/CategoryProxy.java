package com.example.application.supplier_category_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "host",url = "http://localhost:9598/category")
public interface CategoryProxy {

    @GetMapping("/v1")
    List<CategoryDTO> getAll();

    @PostMapping("/v1")
    void save(@RequestBody CategoryDTO categoryDTO);
}
