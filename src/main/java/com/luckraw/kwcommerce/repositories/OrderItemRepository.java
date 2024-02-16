package com.luckraw.kwcommerce.repositories;

import com.luckraw.kwcommerce.entities.OrderItem;
import com.luckraw.kwcommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
