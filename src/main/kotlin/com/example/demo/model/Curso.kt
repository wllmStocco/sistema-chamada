package com.example.demo.model

data class Curso(
        val id: Int,
        val nome: String,
        val descricao: String,
        val professor: TipoUsuario
)
