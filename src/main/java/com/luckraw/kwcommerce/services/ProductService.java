package com.luckraw.kwcommerce.services;

import com.luckraw.kwcommerce.dto.ProductDTO;
import com.luckraw.kwcommerce.entities.Product;
import com.luckraw.kwcommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {

        Product product = repository.findById(id).get();

        return new ProductDTO(product);
    }

    public Page<ProductDTO> findAll(Pageable pageable) {

        Page<Product> products = repository.findAll(pageable);

        return products.map(x -> new ProductDTO(x));
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

        Product product = repository.getReferenceById(id);
        copyDtoToEntity(productDTO, product);

        repository.save(product);

        return new ProductDTO(product);
    }

    @Transactional
    public void delete(Long id) {

        repository.deleteById(id);
    }


    private void copyDtoToEntity(ProductDTO productDTO, Product product) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImgUrl(productDTO.getImgUrl());
    }
}
