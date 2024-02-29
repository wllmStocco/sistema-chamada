package com.example.demo.model

import java.util.Date

data class CalendarioAulas(
        val id: Int,
        val data: Date,
        val descricao: String,
        val turmaId: Int
)
