package com.example.demo.repository

import com.example.demo.model.Presenca
import org.springframework.stereotype.Repository
import java.text.SimpleDateFormat

@Repository
class PresencaRepository {

    private val presencas: MutableList<Presenca> = mutableListOf(
            Presenca(
                    id = 1,
                    data = SimpleDateFormat("yyyy-MM-dd").parse("2024-02-26"),
                    alunoId = 1,
                    turmaId = 101
            ),
            Presenca(
                    id = 2,
                    data = SimpleDateFormat("yyyy-MM-dd").parse("2024-02-26"),
                    alunoId = 2,
                    turmaId = 102
            ),
            Presenca(
                    id = 3,
                    data = SimpleDateFormat("yyyy-MM-dd").parse("2024-02-26"),
                    alunoId = 1,
                    turmaId = 103
            )
    )

    private var idCounter: Int = 4

    fun findAll(): List<Presenca> {
        return presencas
    }

    fun findById(id: Int): Presenca? {
        return presencas.find { it.id == id }
    }

    fun save(presenca: Presenca) {
        presencas.add(presenca.copy(id = idCounter))
        idCounter++
    }

    fun deleteById(id: Int) {
        val presenca = presencas.find { it.id == id }
        presenca?.let { presencas.remove(it) }
    }
}
