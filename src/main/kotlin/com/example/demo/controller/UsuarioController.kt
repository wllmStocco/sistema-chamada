package com.example.demo.controller
import com.example.demo.dto.UsuarioDTO
import com.example.demo.dto.UsuarioResponseDTO
import com.example.demo.service.UsuarioService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(val service: UsuarioService) {
    @GetMapping
    fun listar(): List<UsuarioResponseDTO> {
        return service.listar()
    }
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): UsuarioResponseDTO {
        return service.buscarPorId(id)
    }
    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: UsuarioDTO) {
        service.cadastrar(dto)
    }
    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: UsuarioDTO) {
        service.atualizar(id, dto)
    }
    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}

