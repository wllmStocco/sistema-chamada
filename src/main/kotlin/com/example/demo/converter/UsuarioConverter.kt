package com.example.demo.converter

import com.example.demo.dto.UsuarioDTO
import com.example.demo.dto.UsuarioResponseDTO
import com.example.demo.model.Usuario
import org.springframework.stereotype.Component

@Component
class UsuarioConverter {
    fun toUsuario(dto: UsuarioDTO): Usuario {
        return Usuario(
                id = dto.id,
                nome = dto.nome,
                email = dto.email,
                senha = dto.senha,
                tipo = dto.tipo,
                foto = dto.foto,
                endereco = dto.endereco,
                numero = dto.numero,
                responsavelLegal = dto.responsavelLegal
        )
    }
    fun toUsuarioResponseDTO(usuario: Usuario): UsuarioResponseDTO {
        return UsuarioResponseDTO(
                id = usuario.id,
                nome = usuario.nome,
                email = usuario.email,
                senha = usuario.senha,
                tipo = usuario.tipo,
                foto = usuario.foto,
                endereco = usuario.endereco,
                numero= usuario.numero,
                responsavelLegal= usuario.responsavelLegal
        )
    }
}