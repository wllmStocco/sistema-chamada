package com.example.demo.converter

import com.example.demo.dto.DataEventoDTO
import com.example.demo.model.DataEvento
import com.example.demo.model.TipoEvento
import org.springframework.stereotype.Component

@Component
class DataEventoConverter {

    fun toDataEvento(dto: DataEventoDTO): DataEvento {
        return DataEvento(
                id = dto.id ?: 0,
                tipo = TipoEvento.valueOf(dto.tipo),
                data = dto.data,
                descricao = dto.descricao,
                turmaId = dto.turmaId
        )
    }

    fun toDataEventoDTO(dataEvento: DataEvento): DataEventoDTO {
        return DataEventoDTO(
                id = dataEvento.id,
                tipo = dataEvento.tipo.name,
                data = dataEvento.data,
                descricao = dataEvento.descricao,
                turmaId = dataEvento.turmaId
        )
    }
}
