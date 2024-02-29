package com.example.demo.controller
import com.example.demo.dto.CursoDTO
import com.example.demo.dto.CursoResponseDTO
import com.example.demo.service.CursoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cursos")
class CursoController(val service: CursoService) {
    @GetMapping
    fun listar(): List<CursoResponseDTO> {
        return service.listar()
    }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): CursoResponseDTO {
        return service.buscarPorId(id)
    }
    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: CursoDTO) {
        service.cadastrar(dto)
    }
    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Int, @RequestBody @Valid dto: CursoDTO) {
        service.atualizar(id, dto)
    }
    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
