package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.Users;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.security.userpincal.UserDetailService;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;
    @Autowired
    UserDetailService userDetailService;
    @Override
    public Category save(Category category) {
        Users users = userDetailService.getCurrentUser();
        category.setUsers(users);
        return categoryRepository.save(category);
    }
}
