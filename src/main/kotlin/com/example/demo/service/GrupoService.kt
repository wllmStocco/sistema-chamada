package com.example.demo.service

import com.example.demo.converter.GrupoConverter
import com.example.demo.dto.GrupoDTO
import com.example.demo.dto.GrupoResponseDTO
import com.example.demo.repository.GrupoRepository
import org.springframework.stereotype.Service

@Service
class GrupoService(private val repository: GrupoRepository,
                   private val converter: GrupoConverter) {

    private var idCounter: Int = 204 // Considerando que já existem grupos com IDs até 203

    fun cadastrar(grupo: GrupoDTO) {
        repository.save(converter.toGrupo(grupo).copy(id = idCounter))
        idCounter++
    }

    fun listar(): List<GrupoResponseDTO> {
        return repository.findAll()
                .map(converter::toGrupoResponseDTO)
    }

    fun buscarPorId(id: Int): GrupoResponseDTO {
        val grupo = repository.findById(id)
                ?: throw NoSuchElementException("Grupo não encontrado")
        return converter.toGrupoResponseDTO(grupo)
    }

    fun atualizar(id: Int, dto: GrupoDTO) {
        val grupoExistente = repository.findById(id)
                ?: throw NoSuchElementException("Grupo não encontrado")
        val grupoAtualizado = converter.toGrupo(dto).copy(id = id)
        repository.save(grupoAtualizado)
    }

    fun deletar(id: Int) {
        repository.deleteById(id)
    }
}
