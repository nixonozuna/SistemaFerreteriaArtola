package com.example.sistemaferreteriaartola.repository;

import com.example.sistemaferreteriaartola.entity.unidadmedidaentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface unidadmedidarepository extends JpaRepository<unidadmedidaentity, Integer> {
}