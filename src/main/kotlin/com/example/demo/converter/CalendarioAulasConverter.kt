package com.example.demo.converter

import com.example.demo.dto.CalendarioAulasDTO
import com.example.demo.dto.CalendarioAulasResponseDTO
import com.example.demo.model.CalendarioAulas
import org.springframework.stereotype.Component

@Component
class CalendarioAulasConverter {

    fun toCalendarioAulas(dto: CalendarioAulasDTO): CalendarioAulas {
        return CalendarioAulas(
                id = dto.id ?: 0,
                data = dto.data,
                descricao = dto.descricao,
                turmaId = dto.turmaId
        )
    }

    fun toCalendarioAulasDTO(calendarioAulas: CalendarioAulas): CalendarioAulasDTO {
        return CalendarioAulasDTO(
                id = calendarioAulas.id,
                data = calendarioAulas.data,
                descricao = calendarioAulas.descricao,
                turmaId = calendarioAulas.turmaId
        )
    }

    fun toCalendarioAulasResponseDTO(calendarioAulas: CalendarioAulas): CalendarioAulasResponseDTO {
        return CalendarioAulasResponseDTO(
                id = calendarioAulas.id,
                data = calendarioAulas.data,
                descricao = calendarioAulas.descricao,
                turmaId = calendarioAulas.turmaId
        )
    }
}
