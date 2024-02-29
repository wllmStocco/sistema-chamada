package com.example.demo.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class TurmaDTO(
        @field:NotNull(message = "O ID da turma não pode ser nulo")
        val id: Int,

        @field:NotBlank(message = "Nome da turma não pode estar em branco")
        val nome: String,

        @field:NotNull(message = "O ID do curso não pode ser nulo")
        val cursoId: Int
)