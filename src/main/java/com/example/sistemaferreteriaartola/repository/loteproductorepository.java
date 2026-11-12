package com.example.sistemaferreteriaartola.repository;

import com.example.sistemaferreteriaartola.entity.loteproductoentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loteproductorepository extends JpaRepository<loteproductoentity, Integer> {
}