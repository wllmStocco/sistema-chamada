package com.example.demo.repository

import com.example.demo.model.CalendarioAulas
import org.springframework.stereotype.Repository
import java.sql.Date

@Repository
class CalendarioAulasRepository {

    private val aulas: MutableList<CalendarioAulas> = mutableListOf(
            CalendarioAulas(
                    id = 1,
                    data = Date.valueOf("2024-03-01"),
                    descricao = "Introdução ao curso",
                    turmaId = 101
            ),
            CalendarioAulas(
                    id = 2,
                    data = Date.valueOf("2024-03-03"),
                    descricao = "Revisão de conceitos básicos",
                    turmaId = 101
            ),
            CalendarioAulas(
                    id = 3,
                    data = Date.valueOf("2024-03-05"),
                    descricao = "Exercícios práticos",
                    turmaId = 101
            ),
            CalendarioAulas(
                    id = 4,
                    data = Date.valueOf("2024-03-02"),
                    descricao = "Discussão sobre temas específicos",
                    turmaId = 102
            ),
            CalendarioAulas(
                    id = 5,
                    data = Date.valueOf("2024-03-04"),
                    descricao = "Apresentação de trabalhos",
                    turmaId = 102
            ),
            CalendarioAulas(
                    id = 6,
                    data = Date.valueOf("2024-03-06"),
                    descricao = "Aprofundamento teórico",
                    turmaId = 102
            ),
            CalendarioAulas(
                    id = 7,
                    data = Date.valueOf("2024-03-07"),
                    descricao = "Análise de casos práticos",
                    turmaId = 103
            ),
            CalendarioAulas(
                    id = 8,
                    data = Date.valueOf("2024-03-09"),
                    descricao = "Estudo de casos reais",
                    turmaId = 103
            ),
            CalendarioAulas(
                    id = 9,
                    data = Date.valueOf("2024-03-11"),
                    descricao = "Revisão para a prova",
                    turmaId = 103
            )
    )

    fun findAll(): List<CalendarioAulas> {
        return aulas
    }

    fun findById(id: Int): CalendarioAulas? {
        return aulas.find { it.id == id }
    }

    fun save(aula: CalendarioAulas) {
        aulas.add(aula)
    }

    fun deleteById(id: Int) {
        val aula = aulas.find { it.id == id }
        aula?.let { aulas.remove(it) }
    }
}
