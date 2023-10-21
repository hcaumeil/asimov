package com.sud.asimov;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
interface FileRepository : JpaRepository<File, String> {}