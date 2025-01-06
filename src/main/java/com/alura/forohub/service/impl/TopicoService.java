package com.alura.forohub.service.impl;

import com.alura.forohub.dto.request.TopicoRequestDto;
import com.alura.forohub.dto.response.TopicoResponseDto;
import com.alura.forohub.entity.Topico;
import com.alura.forohub.repository.ITopicoRepository;
import com.alura.forohub.service.ITopicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class TopicoService implements ITopicoService {

    private ITopicoRepository topicoRepository;

    public TopicoService(ITopicoRepository topicoRepository){
        this.topicoRepository = topicoRepository;
    }

    @Override
    public TopicoResponseDto crearTopico(TopicoRequestDto topico) {

        Topico topicoCreado =  topicoRepository.save(new Topico(topico));

        return new TopicoResponseDto(
                topicoCreado.getId(),
                topicoCreado.getTitulo(),
                topicoCreado.getMensaje(),
                topicoCreado.getFechaCreacion(),
                topicoCreado.getStatus() == 1,
                topicoCreado.getAutorId()
                );
    }

    @Override
    public Page<TopicoResponseDto> obtenerTopicos(Pageable paginacion) {
        return topicoRepository
                .findAll(paginacion)
                .map(TopicoResponseDto::new);
    }
}
