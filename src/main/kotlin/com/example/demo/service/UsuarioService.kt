package com.example.demo.service

import com.example.demo.converter.UsuarioConverter
import com.example.demo.dto.UsuarioDTO
import com.example.demo.dto.UsuarioResponseDTO
import com.example.demo.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val repository: UsuarioRepository,
                     private val converter: UsuarioConverter
) {
    fun listar(): List<UsuarioResponseDTO> {
        return repository.findAll()
                .map(converter::toUsuarioResponseDTO)
    }
    fun buscarPorId(id: Long): UsuarioResponseDTO {
        val usuario = repository.findAll().first{ it.id.toLong() == id}
        return converter.toUsuarioResponseDTO(usuario)
    }
    fun cadastrar(usuario: UsuarioDTO) {
        repository.cadastrar(converter.toUsuario(usuario))
    }
    fun atualizar(id: Long, dto: UsuarioDTO) {
        repository.update(id, converter.toUsuario(dto))
    }
    fun deletar(id: Long) {
        repository.deletar(id)
    }

}


