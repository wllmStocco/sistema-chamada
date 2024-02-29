package com.example.demo.service


import com.example.demo.converter.PresencaConverter
import com.example.demo.dto.PresencaDTO
import com.example.demo.dto.PresencaResponseDTO
import com.example.demo.model.Presenca
import com.example.demo.repository.PresencaRepository
import org.springframework.stereotype.Service

@Service
class PresencaService(private val repository: PresencaRepository,
                      private val converter: PresencaConverter
) {

    private var idCounter: Int = 4

    fun cadastrar(presenca: PresencaDTO) {
        repository.save(
                Presenca(
                        id = idCounter,
                        data = presenca.data,
                        alunoId = presenca.alunoId,
                        turmaId = presenca.turmaId
                )
        )
        idCounter++
    }

    fun listar(): List<PresencaResponseDTO> {
        return repository.findAll().map(converter::toPresencaResponseDTO)
    }

    fun buscarPorId(id: Int): PresencaResponseDTO {
        val presenca = repository.findById(id) ?: throw NoSuchElementException("Presença não encontrada")
        return converter.toPresencaResponseDTO(presenca)
    }

    fun atualizar(id: Int, presencaDTO: PresencaDTO) {
        val presencaExistente = repository.findById(id)
                ?: throw NoSuchElementException("Presença não encontrada")
        val presencaAtualizada = Presenca(
                id = id,
                data = presencaDTO.data,
                alunoId = presencaDTO.alunoId,
                turmaId = presencaDTO.turmaId
        )
        repository.save(presencaAtualizada)
    }

    fun deletar(id: Int) {
        repository.deleteById(id)
    }
}
