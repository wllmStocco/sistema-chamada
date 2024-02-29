package com.example.demo.dto

import com.example.demo.model.TipoEvento
import java.util.*

class DataEventoResponseDTO(
        val id: Int,
        val tipo: TipoEvento,
        val data: Date,
        val descricao: String,
        val turmaId: Int
)