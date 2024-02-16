package com.luckraw.kwcommerce.services;

import com.luckraw.kwcommerce.dto.OrderDTO;
import com.luckraw.kwcommerce.entities.Order;
import com.luckraw.kwcommerce.repositories.OrderRepository;
import com.luckraw.kwcommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {

        Order order = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

        return new OrderDTO(order);
    }
}
