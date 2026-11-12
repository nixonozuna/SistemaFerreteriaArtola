package com.example.sistemaferreteriaartola.repository;

import com.example.sistemaferreteriaartola.entity.usuarioentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuariorepository extends JpaRepository<usuarioentity, Integer> {
}
