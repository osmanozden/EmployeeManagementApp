package com.circle.controller;

import com.circle.entity.RequestCategory;
import com.circle.repository.RequestCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("requestCategory")
public class RequestCategoryController {

    @Autowired
    private RequestCategoryRepository  requestCategoryRepository;

    @GetMapping(value = "getAllCategory")
    public List<RequestCategory> RequestCategoryController() {
        return requestCategoryRepository.findAll();
    }

}
