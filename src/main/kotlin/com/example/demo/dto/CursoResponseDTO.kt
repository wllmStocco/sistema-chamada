package com.example.demo.dto

import com.example.demo.model.TipoUsuario

data class CursoResponseDTO(
        val id: Int,
        val nome: String,
        val descricao: String,
        val professor: TipoUsuario
)
