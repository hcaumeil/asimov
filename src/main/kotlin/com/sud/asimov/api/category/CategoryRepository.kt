package com.sud.asimov;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {}