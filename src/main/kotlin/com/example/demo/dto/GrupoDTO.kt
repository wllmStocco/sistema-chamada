package com.example.demo.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class GrupoDTO(
        @field:NotNull(message = "O ID do grupo não pode ser nulo")
        val id: Int,

        @field:NotBlank(message = "Nome do grupo não pode estar em branco")
        val nome: String,

        @field:NotNull(message = "O ID da turma não pode ser nulo")
        val turmaId: Int
)
