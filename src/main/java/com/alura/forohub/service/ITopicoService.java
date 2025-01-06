package com.alura.forohub.service;

import com.alura.forohub.dto.request.TopicoRequestDto;
import com.alura.forohub.dto.response.TopicoResponseDto;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITopicoService {

    TopicoResponseDto crearTopico(TopicoRequestDto topico);
    Page<TopicoResponseDto> obtenerTopicos(Pageable paginacion);
    TopicoResponseDto obtenerTopicoPorId(Long id) throws BadRequestException;
    TopicoResponseDto actualizarTopico(Long id, TopicoRequestDto topico) throws BadRequestException;
    void eliminarTopicoPorId(Long id) throws BadRequestException;

}
