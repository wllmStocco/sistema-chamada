package com.example.demo.controller

import com.example.demo.dto.PresencaDTO
import com.example.demo.dto.PresencaResponseDTO
import com.example.demo.service.PresencaService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/presencas")
class PresencaController(val service: PresencaService) {
    @GetMapping
    fun listar(): List<PresencaResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int): PresencaResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: PresencaDTO) {
        service.cadastrar(dto)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Int, @RequestBody @Valid dto: PresencaDTO) {
        service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Int) {
        service.deletar(id)
    }
}
