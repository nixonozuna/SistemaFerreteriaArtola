package com.example.sistemaferreteriaartola.repository;

import com.example.sistemaferreteriaartola.entity.productoentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productorepository extends JpaRepository<productoentity, Integer> {
}