package com.alura.forohub.controller;

import com.alura.forohub.dto.request.TopicoRequestDto;
import com.alura.forohub.dto.response.TopicoResponseDto;
import com.alura.forohub.service.ITopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private ITopicoService topicoService;

    public TopicoController(ITopicoService topicoService){
        this.topicoService = topicoService;
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<TopicoResponseDto> crearTopico(@RequestBody @Valid TopicoRequestDto topico){
        return ResponseEntity.ok(topicoService.crearTopico(topico));
    }

    @GetMapping()
    public ResponseEntity<Page<TopicoResponseDto>> obtenerTopicos(@PageableDefault(sort = "fechaCreacion",
                                                                                   direction = Sort.Direction.ASC) Pageable paginacion){
        return ResponseEntity.ok(topicoService.obtenerTopicos(paginacion));
    }

    @GetMapping("{id}")
    public ResponseEntity<TopicoResponseDto> obtenerTopicoPorId(@PathVariable Long id) throws BadRequestException {
        return ResponseEntity.ok(topicoService.obtenerTopicoPorId(id));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<TopicoResponseDto> actualizarTopicoPorId(@PathVariable Long id, @RequestBody @Valid
                                                                   TopicoRequestDto topico) throws BadRequestException{
        return ResponseEntity.ok(topicoService.actualizarTopico(id, topico));
    }


    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity eliminarTopicoPorId(@PathVariable Long id) throws BadRequestException{
        topicoService.eliminarTopicoPorId(id);
        return ResponseEntity.noContent().build();
    }

}
