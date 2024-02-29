package com.example.demo.repository

import com.example.demo.model.Curso
import com.example.demo.model.TipoUsuario
import org.springframework.stereotype.Repository

@Repository
class CursoRepository {

    private val cursos: MutableList<Curso> = mutableListOf(
            Curso(
                    id = 1,
                    nome = "Curso 1",
                    descricao = "Descrição do Curso 1",
                    professor = TipoUsuario.PROFESSOR
            ),
            Curso(
                    id = 2,
                    nome = "Curso 2",
                    descricao = "Descrição do Curso 2",
                    professor = TipoUsuario.PROFESSOR
            ),
            Curso(
                    id = 3,
                    nome = "Curso 3",
                    descricao = "Descrição do Curso 3",
                    professor = TipoUsuario.ADM
            )
    )

    private var idCont: Int = 4

    fun findAll(): List<Curso> {
        return cursos
    }

    fun findById(id: Int): Curso? {
        return cursos.find { it.id.toLong().toInt() == id }
    }

    fun save(curso: Curso) {
        cursos.add(curso.copy(id = idCont))
    }

    fun deleteById(id: Long) {
        val curso = cursos.find { it.id.toLong() == id }
        curso?.let { cursos.remove(it) }
    }
}
