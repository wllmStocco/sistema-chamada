package com.example.demo.dto

import com.example.demo.model.TipoUsuario

data class UsuarioResponseDTO (
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