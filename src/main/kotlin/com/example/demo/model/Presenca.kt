package com.example.demo.model

import java.util.Date

data class Presenca(
        val id: Int,
        val data: Date,
        val alunoId: Int,
        val turmaId: Int
)
