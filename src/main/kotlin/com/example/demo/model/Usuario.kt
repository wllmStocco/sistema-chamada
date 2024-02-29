package com.example.demo.model

data class Usuario(
        val id: Int,
        val nome: String,
        val email: String,
        val senha: String,
        val tipo: TipoUsuario,
        val foto: String,
        val endereco: String,
        val numero: Int,
        val responsavelLegal: String
)

enum class TipoUsuario {
    ALUNO,
    PROFESSOR,
    ADM
}
