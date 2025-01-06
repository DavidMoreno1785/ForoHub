package com.alura.forohub.entity;

import com.alura.forohub.dto.request.TopicoRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensaje;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    private Integer status;
    @Column(name = "usuario_id")
    private Long autorId;
    @Column(name = "curso_id")
    private Long curso;


    public Topico(TopicoRequestDto topico) {

        this.titulo = topico.titulo();
        this.mensaje = topico.mensaje();
        this.fechaCreacion = LocalDate.now();
        this.status = 1;
        this.autorId = topico.autorId();
        this.curso = 1L;

    }
}
