package com.alura.forohub.controller;

import com.alura.forohub.dto.request.TopicoRequestDto;
import com.alura.forohub.dto.response.TopicoResponseDto;
import com.alura.forohub.service.ITopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<Page<TopicoResponseDto>> obtenerTopicos(@PageableDefault(size = 10) Pageable paginacion){
        return ResponseEntity.ok(topicoService.obtenerTopicos(paginacion));
    }

}
