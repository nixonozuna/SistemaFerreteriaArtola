package com.example.sistemaferreteriaartola.repository;

import com.example.sistemaferreteriaartola.entity.compraentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface comprarepository extends JpaRepository<compraentity, Integer> {
}