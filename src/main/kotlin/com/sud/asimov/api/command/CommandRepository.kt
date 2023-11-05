package com.sud.asimov;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sud.asimov.Command;

@Repository
interface CommandRepository : JpaRepository<Command, Long> {
  fun findByUser(user: User): List<Command>
  fun findByUserId(userId: Long): List<Command>
}
