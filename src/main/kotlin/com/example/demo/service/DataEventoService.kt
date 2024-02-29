package com.example.demo.service

import com.example.demo.converter.DataEventoConverter
import com.example.demo.dto.DataEventoDTO
import com.example.demo.repository.DataEventoRepository
import org.springframework.stereotype.Service

@Service
class DataEventoService(private val repository: DataEventoRepository,
                        private val converter: DataEventoConverter
) {

    fun listar(): List<DataEventoDTO> {
        return repository.findAll().map(converter::toDataEventoDTO)
    }

    fun buscarPorId(id: Int): DataEventoDTO {
        val evento = repository.findById(id) ?: throw NoSuchElementException("Evento não encontrado")
        return converter.toDataEventoDTO(evento)
    }

    fun cadastrar(dto: DataEventoDTO) {
        val evento = converter.toDataEvento(dto)
        repository.save(evento)
    }

    fun atualizar(id: Int, dto: DataEventoDTO) {
        val eventoExistente = repository.findById(id)
                ?: throw NoSuchElementException("Evento não encontrado")
        val eventoAtualizado = converter.toDataEvento(dto).copy(id = id)
        repository.save(eventoAtualizado)
    }

    fun deletar(id: Int) {
        repository.deleteById(id)
    }
}
