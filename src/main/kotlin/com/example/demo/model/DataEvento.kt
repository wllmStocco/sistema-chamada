package com.example.demo.model

import java.util.Date

data class DataEvento(
        val id: Int,
        val tipo: TipoEvento,
        val data: Date,
        val descricao: String,
        val turmaId: Int
)

enum class TipoEvento {
    Prova,
    Trabalho
}
