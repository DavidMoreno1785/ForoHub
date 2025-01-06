package com.alura.forohub.service;

import com.alura.forohub.dto.request.TopicoRequestDto;
import com.alura.forohub.dto.response.TopicoResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITopicoService {

    TopicoResponseDto crearTopico(TopicoRequestDto topico);
    Page<TopicoResponseDto> obtenerTopicos(Pageable paginacion);

}
