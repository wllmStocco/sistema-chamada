package com.example.demo.converter

import com.example.demo.dto.GrupoDTO
import com.example.demo.dto.GrupoResponseDTO
import com.example.demo.model.Grupo
import org.springframework.stereotype.Component

@Component
class GrupoConverter {
    fun toGrupo(dto: GrupoDTO): Grupo {
        return Grupo(
                id = dto.id,
                nome = dto.nome,
                turmaId = dto.turmaId
        )
    }
    fun toGrupoResponseDTO(grupo: Grupo): GrupoResponseDTO {
        return GrupoResponseDTO(
                id = grupo.id,
                nome = grupo.nome,
                turmaId = grupo.turmaId
        )
    }
}