package com.example.demo.dto

import com.example.demo.model.TipoUsuario
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CursoDTO(
        @field:NotNull(message = "O ID do curso não pode ser nulo")
        val id: Int,

        @field:NotBlank(message = "Nome do curso não pode estar em branco")
        val nome: String,

        @field:NotBlank(message = "Descrição do curso não pode estar em branco")
        val descricao: String,

        @field:NotNull(message = "O tipo do professor não pode ser nulo")
        val professor: TipoUsuario
)