package com.example.demo.converter


import com.example.demo.dto.TurmaDTO
import com.example.demo.dto.TurmaResponseDTO
import com.example.demo.model.Turma
import org.springframework.stereotype.Component

@Component
class TurmaConverter {
    fun toTurma(dto: TurmaDTO): Turma {
        return Turma(
                id = dto.id,
                nome = dto.nome,
                cursoId = dto.cursoId
        )
    }
    fun toTurmaResponseDTO(turma: Turma): TurmaResponseDTO {
        return TurmaResponseDTO(
                id = turma.id,
                nome = turma.nome,
                cursoId = turma.cursoId
        )
    }
}