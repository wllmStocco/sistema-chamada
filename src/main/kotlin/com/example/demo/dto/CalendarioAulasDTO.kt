package com.example.demo.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.Date

data class CalendarioAulasDTO(
        @field:NotNull(message = "O ID da aula não pode ser nulo")
        val id: Int?,

        @field:NotNull(message = "A data da aula não pode ser nula")
        val data: Date,

        @field:NotBlank(message = "A descrição da aula não pode estar em branco")
        val descricao: String,

        @field:NotNull(message = "O ID da turma não pode ser nulo")
        val turmaId: Int
)
