package com.example.demo.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.Date

data class DataEventoDTO(
        @field:NotNull(message = "O ID do evento não pode ser nulo")
        val id: Int?,

        @field:NotBlank(message = "O tipo do evento não pode estar em branco")
        val tipo: String,

        @field:NotNull(message = "A data do evento não pode ser nula")
        val data: Date,

        @field:NotBlank(message = "A descrição do evento não pode estar em branco")
        val descricao: String,

        @field:NotNull(message = "O ID da turma não pode ser nulo")
        val turmaId: Int
)
