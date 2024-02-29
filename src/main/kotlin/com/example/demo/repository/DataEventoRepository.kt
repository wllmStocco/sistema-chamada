package com.example.demo.repository

import com.example.demo.model.DataEvento
import com.example.demo.model.TipoEvento
import org.springframework.stereotype.Repository
import java.sql.Date

@Repository
class DataEventoRepository {

    private val eventos: MutableList<DataEvento> = mutableListOf(
            DataEvento(
                    id = 1,
                    tipo = TipoEvento.Prova,
                    data = Date.valueOf("2024-03-10"),
                    descricao = "Prova parcial do curso",
                    turmaId = 101
            ),
            DataEvento(
                    id = 2,
                    tipo = TipoEvento.Trabalho,
                    data = Date.valueOf("2024-03-15"),
                    descricao = "Apresentação de trabalhos sobre o tema",
                    turmaId = 102
            ),
            DataEvento(
                    id = 3,
                    tipo = TipoEvento.Prova,
                    data = Date.valueOf("2024-03-20"),
                    descricao = "Prova final do semestre",
                    turmaId = 103
            )
    )

    fun findAll(): List<DataEvento> {
        return eventos
    }

    fun findById(id: Int): DataEvento? {
        return eventos.find { it.id == id }
    }

    fun save(evento: DataEvento) {
        eventos.add(evento)
    }

    fun deleteById(id: Int) {
        val evento = eventos.find { it.id == id }
        evento?.let { eventos.remove(it) }
    }
}
