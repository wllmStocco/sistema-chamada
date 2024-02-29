package com.example.demo.controller

import com.example.demo.dto.GrupoDTO
import com.example.demo.dto.GrupoResponseDTO
import com.example.demo.service.GrupoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/grupos")
class GrupoController(val service: GrupoService) {
    @GetMapping
    fun listar(): List<GrupoResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int): GrupoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: GrupoDTO) {
        service.cadastrar(dto)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Int, @RequestBody @Valid dto: GrupoDTO) {
        service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Int) {
        service.deletar(id)
    }
}
