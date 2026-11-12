package com.example.sistemaferreteriaartola.repository;

import com.example.sistemaferreteriaartola.entity.rolentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rolrepository extends JpaRepository<rolentity, Integer> {
}