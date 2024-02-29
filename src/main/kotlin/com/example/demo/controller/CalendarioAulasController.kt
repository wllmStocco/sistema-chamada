package com.example.demo.controller

import com.example.demo.dto.CalendarioAulasDTO
import com.example.demo.dto.CalendarioAulasResponseDTO
import com.example.demo.service.CalendarioAulasService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/calendarioaulas")
class CalendarioAulasController(private val service: CalendarioAulasService) {

    @GetMapping
    fun listar(): List<CalendarioAulasResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int): CalendarioAulasResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: CalendarioAulasDTO) {
        service.cadastrar(dto)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Int, @RequestBody @Valid dto: CalendarioAulasDTO) {
        service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Int) {
        service.deletar(id)
    }
}
