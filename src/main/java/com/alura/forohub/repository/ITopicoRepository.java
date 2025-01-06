package com.alura.forohub.repository;

import com.alura.forohub.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {
}
