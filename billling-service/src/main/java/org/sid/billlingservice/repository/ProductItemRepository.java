package org.sid.billlingservice.repository;

import org.sid.billlingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}