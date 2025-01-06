package com.alura.forohub.service.impl;

import com.alura.forohub.dto.request.TopicoRequestDto;
import com.alura.forohub.dto.response.TopicoResponseDto;
import com.alura.forohub.entity.Topico;
import com.alura.forohub.repository.ITopicoRepository;
import com.alura.forohub.service.ITopicoService;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

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

    @Override
    public TopicoResponseDto obtenerTopicoPorId(Long id) throws BadRequestException {
        Optional <Topico> topicoEncontrado = topicoRepository.findById(id);

        if(topicoEncontrado.isPresent()){
            Topico topico = topicoEncontrado.get();
            return new TopicoResponseDto( topico.getId(),
                                          topico.getTitulo(),
                                          topico.getMensaje(),
                                          topico.getFechaCreacion(),
                                          topico.getStatus() == 1,
                                          topico.getAutorId());
        }
        throw new BadRequestException("El topico no existe");
    }

    @Override
    public TopicoResponseDto actualizarTopico(Long id, TopicoRequestDto topico) throws BadRequestException {
        Optional<Topico> topicoEncontrado = topicoRepository.findById(id);

        if(topicoEncontrado.isPresent()){
            Topico topicoEntity = topicoEncontrado.get();
            topicoEntity.actualizarTopico(topico);
            return new TopicoResponseDto(topicoEntity.getId(),
                                         topicoEntity.getTitulo(),
                                         topicoEntity.getMensaje(),
                                         topicoEntity.getFechaCreacion(),
                                         topicoEntity.getStatus() == 1,
                                         topicoEntity.getAutorId());
        }

        throw new BadRequestException("El topico no existe");
    }

    @Override
    public void eliminarTopicoPorId(Long id) throws BadRequestException {
        Optional<Topico> topicoEncontrado = topicoRepository.findById(id);
        if(topicoEncontrado.isPresent()){
            topicoRepository.deleteById(id);
        }else{
            throw new BadRequestException("El topico no existe");
        }
    }
}
