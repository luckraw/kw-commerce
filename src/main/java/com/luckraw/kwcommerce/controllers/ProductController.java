package com.luckraw.kwcommerce.controllers;

import com.luckraw.kwcommerce.dto.ProductDTO;
import com.luckraw.kwcommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        return service.create(productDTO);
    }

}
