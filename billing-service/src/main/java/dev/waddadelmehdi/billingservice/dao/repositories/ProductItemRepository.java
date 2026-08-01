package dev.waddadelmehdi.billingservice.dao.repositories;

import dev.waddadelmehdi.billingservice.dao.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}
