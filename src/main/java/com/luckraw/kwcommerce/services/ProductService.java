package com.luckraw.kwcommerce.services;

import com.luckraw.kwcommerce.dto.CategoryDTO;
import com.luckraw.kwcommerce.dto.ProductDTO;
import com.luckraw.kwcommerce.dto.ProductMinDTO;
import com.luckraw.kwcommerce.entities.Category;
import com.luckraw.kwcommerce.entities.Product;
import com.luckraw.kwcommerce.repositories.ProductRepository;
import com.luckraw.kwcommerce.services.exceptions.DatabaseException;
import com.luckraw.kwcommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAll(String name, Pageable pageable) {

        Page<Product> products = repository.searchByName(name, pageable);

        return products.map(x -> new ProductMinDTO(x));
    }

    @Transactional
    public ProductDTO create(ProductDTO productDTO) {

        Product product = new Product();
        copyDtoToEntity(productDTO, product);

        repository.save(product);

        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {

        try {
            Product product = repository.getReferenceById(id);
            copyDtoToEntity(productDTO, product);

            repository.save(product);

            return new ProductDTO(product);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {

        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        try {
            repository.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }

    }


    private void copyDtoToEntity(ProductDTO dto, Product product) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImgUrl(dto.getImgUrl());

        product.getCategories().clear();
        for (CategoryDTO catDto : dto.getCategories()) {
            Category cat = new Category();
            cat.setId(catDto.getId());
            product.getCategories().add(cat);
        }
    }
}
