package com.sud.asimov;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
  fun findByCategory(category: Category): List<Product>
}