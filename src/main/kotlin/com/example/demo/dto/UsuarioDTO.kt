package com.example.demo.dto


import com.example.demo.model.TipoUsuario
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive


data class UsuarioDTO(
        @field:NotNull(message = "O ID do usuário não pode ser nulo")
        val id: Int,

        @field:NotBlank(message = "Nome do usuário não pode estar em branco")
        val nome: String,

        @field:NotBlank(message = "E-mail do usuário não pode estar em branco")
        val email: String,

        @field:NotBlank(message = "Senha do usuário não pode estar em branco")
        val senha: String,

        @field:NotNull(message = "O tipo do usuário não pode ser nulo")
        val tipo: TipoUsuario,

        @field:NotBlank(message = "Foto do usuário não pode estar em branco")
        val foto: String,

        @field:NotBlank(message = "Endereço do usuário não pode estar em branco")
        val endereco: String,

        @field:Positive(message = "O número do endereço deve ser um valor positivo")
        val numero: Int,

        @field:NotBlank(message = "Responsável legal do usuário não pode estar em branco")
        val responsavelLegal: String,

        @field:NotBlank(message = "QR Code não pode estar em branco")
        val qrCode: String? = null
)
