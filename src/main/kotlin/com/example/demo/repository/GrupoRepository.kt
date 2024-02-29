package com.example.demo.repository

import com.example.demo.model.Grupo
import org.springframework.stereotype.Repository

@Repository
class GrupoRepository {

    private val grupos: MutableList<Grupo> = mutableListOf(
            Grupo(
                    id = 201,
                    nome = "Grupo de Estudo A",
                    turmaId = 101
            ),
            Grupo(
                    id = 202,
                    nome = "Grupo de Discussão B",
                    turmaId = 102
            ),
            Grupo(
                    id = 203,
                    nome = "Grupo de Trabalho C",
                    turmaId = 103
            )
    )

    private var idCounter: Int = 204

    fun findAll(): List<Grupo> {
        return grupos
    }

    fun findById(id: Int): Grupo? {
        return grupos.find { it.id == id }
    }

    fun save(grupo: Grupo) {
        grupos.add(grupo.copy(id = idCounter))
        idCounter++
    }

    fun deleteById(id: Int) {
        val grupo = grupos.find { it.id == id }
        grupo?.let { grupos.remove(it) }
    }
}
