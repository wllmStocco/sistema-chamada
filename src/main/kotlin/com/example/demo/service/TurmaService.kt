package com.example.demo.service


import com.example.demo.converter.TurmaConverter
import com.example.demo.dto.TurmaDTO
import com.example.demo.dto.TurmaResponseDTO
import com.example.demo.repository.TurmaRepository
import org.springframework.stereotype.Service

@Service
class TurmaService(private val repository: TurmaRepository,
                   private val converter: TurmaConverter
) {

    private var idCont: Long = 4L
    private var idContInt: Int = idCont.toInt()

    fun cadastrar(turma: TurmaDTO) {
        repository.save(converter.toTurma(turma).copy(id = idContInt))
        idCont++
    }

    fun listar(): List<TurmaResponseDTO> {
        return repository.findAll()
                .map(converter::toTurmaResponseDTO)
    }

    fun buscarPorId(id: Int): TurmaResponseDTO {
        val turma = repository.findById(id)
                ?: throw NoSuchElementException("Turma não encontrada")
        return converter.toTurmaResponseDTO(turma)
    }

    fun atualizar(id: Int, dto: TurmaDTO) {
        val turmaExistente = repository.findById(id)
                ?: throw NoSuchElementException("Turma não encontrada")
        val turmaAtualizada = converter.toTurma(dto).copy(id = id)
        repository.save(turmaAtualizada)
    }

    fun deletar(id: Int) {
        repository.deleteById(id)
    }
}
