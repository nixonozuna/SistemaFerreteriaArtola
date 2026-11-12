package com.example.sistemaferreteriaartola.repository;

import com.example.sistemaferreteriaartola.entity.proveedorentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface proveedorrepository extends JpaRepository<proveedorentity, Integer> {
}