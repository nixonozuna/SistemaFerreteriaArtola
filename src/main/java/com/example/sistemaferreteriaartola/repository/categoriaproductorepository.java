package com.example.sistemaferreteriaartola.repository;

import com.example.sistemaferreteriaartola.entity.categoriaproductoentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoriaproductorepository extends JpaRepository<categoriaproductoentity, Integer> {
}