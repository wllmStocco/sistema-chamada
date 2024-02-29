package com.example.demo.dto

import java.util.Date

data class CalendarioAulasResponseDTO(
        val id: Int,
        val data: Date,
        val descricao: String,
        val turmaId: Int
)
