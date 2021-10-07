package com.example.demo.controller;

import com.example.demo.dto.response.ResponseMessage;
import com.example.demo.model.Category;
import com.example.demo.model.Users;
import com.example.demo.security.userpincal.UserDetailService;
import com.example.demo.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("category")
@RestController
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    UserDetailService userDetailService;
    @PostMapping()
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        Users users = userDetailService.getCurrentUser();
        if(!users.getUsername().equals("Anonymous")){
            categoryService.save(category);
            return new ResponseEntity<>(new ResponseMessage("create_success"), HttpStatus.OK);
        }
     return new ResponseEntity<>(new ResponseMessage("create_error"), HttpStatus.OK);
    }
}
