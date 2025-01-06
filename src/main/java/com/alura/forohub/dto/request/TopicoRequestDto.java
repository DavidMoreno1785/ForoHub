package com.alura.forohub.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TopicoRequestDto(
        @NotNull(message = "El titulo no puede estar vacio")
        String titulo,
        @NotNull(message = "El mensaje no puede estar vacio")
        String mensaje,
        @Positive(message = "El Id debe ser valido")
        @JsonProperty("autor_id")
        Long autorId,
        @NotNull(message = "El nombre del curso no puede ser vacio")
        @JsonProperty("nombre_curso")
        String nombreCurso
) {
}
