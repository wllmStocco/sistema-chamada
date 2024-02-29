package com.example.demo.converter


import com.example.demo.dto.PresencaDTO
import com.example.demo.dto.PresencaResponseDTO
import com.example.demo.model.Presenca
import org.springframework.stereotype.Component

@Component
class PresencaConverter {
    fun toPresenca(dto: PresencaDTO): Presenca {
        return Presenca(
                id = dto.id,
                data = dto.data,
                alunoId = dto.alunoId,
                turmaId = dto.turmaId
        )
    }
    fun toPresencaResponseDTO(presenca: Presenca): PresencaResponseDTO {
        return PresencaResponseDTO(
                id = presenca.id,
                data = presenca.data,
                alunoId = presenca.alunoId,
                turmaId = presenca.turmaId
        )
    }
}
