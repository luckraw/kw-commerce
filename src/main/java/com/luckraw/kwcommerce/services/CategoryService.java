package com.luckraw.kwcommerce.services;

import com.luckraw.kwcommerce.dto.CategoryDTO;
import com.luckraw.kwcommerce.entities.Category;
import com.luckraw.kwcommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {

        List<Category> result = categoryRepository.findAll();

        return result.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }
}
