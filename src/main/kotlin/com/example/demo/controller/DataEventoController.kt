package com.example.demo.controller

import com.example.demo.dto.DataEventoDTO
import com.example.demo.service.DataEventoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dataeventos")
class DataEventoController(private val service: DataEventoService) {

    @GetMapping
    fun listar(): List<DataEventoDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Int): DataEventoDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: DataEventoDTO) {
        service.cadastrar(dto)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Int, @RequestBody @Valid dto: DataEventoDTO) {
        service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Int) {
        service.deletar(id)
    }
}
