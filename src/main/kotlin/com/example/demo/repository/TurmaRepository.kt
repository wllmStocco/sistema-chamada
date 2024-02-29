package com.example.demo.repository

import com.example.demo.model.Turma
import org.springframework.stereotype.Repository

@Repository
class TurmaRepository {

    private val turmas: MutableList<Turma> = mutableListOf(
            Turma(
                    id = 101,
                    nome = "Turma de Matemática Básica A",
                    cursoId = 1
            ),
            Turma(
                    id = 102,
                    nome = "Turma de História Antiga A",
                    cursoId = 2
            ),
            Turma(
                    id = 103,
                    nome = "Turma de Administração Financeira A",
                    cursoId = 3
            )
    )

    private var idCounter: Int = 104

    fun findAll(): List<Turma> {
        return turmas
    }

    fun findById(id: Int): Turma? {
        return turmas.find { it.id == id }
    }

    fun save(turma: Turma) {
        turmas.add(turma.copy(id = idCounter))
        idCounter++
    }

    fun deleteById(id: Int) {
        val turma = turmas.find { it.id == id }
        turma?.let { turmas.remove(it) }
    }
}
