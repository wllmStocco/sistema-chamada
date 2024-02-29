package com.example.demo.service

import com.example.demo.converter.CalendarioAulasConverter
import com.example.demo.dto.CalendarioAulasDTO
import com.example.demo.dto.CalendarioAulasResponseDTO
import com.example.demo.repository.CalendarioAulasRepository
import org.springframework.stereotype.Service

@Service
class CalendarioAulasService(private val repository: CalendarioAulasRepository,
                             private val converter: CalendarioAulasConverter
) {

    fun listar(): List<CalendarioAulasResponseDTO> {
        return repository.findAll().map(converter::toCalendarioAulasResponseDTO)
    }

    fun buscarPorId(id: Int): CalendarioAulasResponseDTO {
        val aula = repository.findById(id)
                ?: throw NoSuchElementException("Aula não encontrada")
        return converter.toCalendarioAulasResponseDTO(aula)
    }

    fun cadastrar(dto: CalendarioAulasDTO) {
        val aula = converter.toCalendarioAulas(dto)
        repository.save(aula)
    }

    fun atualizar(id: Int, dto: CalendarioAulasDTO) {
        val aulaExistente = repository.findById(id)
                ?: throw NoSuchElementException("Aula não encontrada")
        val aulaAtualizada = converter.toCalendarioAulas(dto).copy(id = id)
        repository.save(aulaAtualizada)
    }

    fun deletar(id: Int) {
        repository.deleteById(id)
    }
}
