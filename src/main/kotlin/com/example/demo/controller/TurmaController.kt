package com.example.demo.controller

import com.example.demo.service.TurmaService
import com.example.demo.dto.TurmaDTO
import com.example.demo.dto.TurmaResponseDTO
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/turmas")
class TurmaController(val service: TurmaService) {
    @GetMapping
    fun listar(): List<TurmaResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int): TurmaResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: TurmaDTO) {
        service.cadastrar(dto)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Int, @RequestBody @Valid dto: TurmaDTO) {
        service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Int) {
        service.deletar(id)
    }
}
