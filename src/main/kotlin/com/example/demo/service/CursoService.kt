package com.example.demo.service

import com.example.demo.converter.CursoConverter
import com.example.demo.dto.CursoDTO
import com.example.demo.dto.CursoResponseDTO
import com.example.demo.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRepository,
                   private val converter: CursoConverter
) {

    private var idCont: Long = 4L
    private var idContInt: Int = idCont.toInt()

    fun cadastrar(curso: CursoDTO) {
        repository.save(converter.toCurso(curso).copy(id = idContInt))
    }

    fun listar(): List<CursoResponseDTO> {
        return repository.findAll()
                .map(converter::toCursoResponseDTO)
    }

    fun buscarPorId(id: Long): CursoResponseDTO {
        val curso = repository.findById(idContInt) ?: throw NoSuchElementException("Curso não encontrado")
        return converter.toCursoResponseDTO(curso)
    }

    fun atualizar(id: Int, dto: CursoDTO) {
        val cursoExistente = repository.findById(id)
                ?: throw NoSuchElementException("Curso não encontrado")
        val cursoAtualizado = converter.toCurso(dto).copy(id = id)
        repository.save(cursoAtualizado)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}
