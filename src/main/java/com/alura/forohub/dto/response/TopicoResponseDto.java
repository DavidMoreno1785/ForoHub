package com.alura.forohub.dto.response;

import com.alura.forohub.entity.Topico;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record TopicoResponseDto(
        Long id,
        String titulo,
        String mensaje,
        @JsonProperty("fecha_creacion")
        LocalDate fechaCreacion,
        Boolean status,
        @JsonProperty("autor_id")
        Long autorId
) {

        public TopicoResponseDto(Topico topico){
                this(topico.getId(),
                     topico.getTitulo(),
                     topico.getMensaje(),
                     topico.getFechaCreacion(),
                     topico.getStatus() == 1,
                     topico.getAutorId());
        }
}
