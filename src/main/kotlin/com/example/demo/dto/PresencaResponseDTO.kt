package com.example.demo.dto


data class PresencaResponseDTO(
        val id: Int,
        val data: java.util.Date,
        val alunoId: Int,
        val turmaId: Int
)