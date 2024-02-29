package com.example.demo.dto

import jakarta.validation.constraints.NotNull
import java.sql.Date

data class PresencaDTO(
        @field:NotNull(message = "O ID da presença não pode ser nulo")
        val id: Int,

        @field:NotNull(message = "A data da presença não pode ser nula")
        val data: Date,

        @field:NotNull(message = "O ID do aluno não pode ser nulo")
        val alunoId: Int,

        @field:NotNull(message = "O ID da turma não pode ser nulo")
        val turmaId: Int
)