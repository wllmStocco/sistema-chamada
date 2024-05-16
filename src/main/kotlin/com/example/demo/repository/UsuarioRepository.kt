package com.example.demo.repository

import com.example.demo.model.TipoUsuario
import com.example.demo.model.Usuario
import com.example.demo.service.QRCodeService
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UsuarioRepository(private val qrCodeService: QRCodeService) {

    private val usuarios: MutableList<Usuario> = mutableListOf(
        Usuario(
            id = 1,
            nome = "João Silva",
            email = "joao@example.com",
            senha = "senha123",
            tipo = TipoUsuario.ALUNO,
            foto = "foto1.jpg",
            endereco = "Rua A",
            numero = 123,
            responsavelLegal = "Jose",
            qrCode = Base64.getEncoder().encodeToString(qrCodeService.generateQRCode("1"))
        ),
        Usuario(
            id = 2,
            nome = "Maria Souza",
            email = "maria@example.com",
            senha = "senha456",
            tipo = TipoUsuario.ALUNO,
            foto = "foto2.jpg",
            endereco = "Rua B",
            numero = 456,
            responsavelLegal = "Jose",
            qrCode = Base64.getEncoder().encodeToString(qrCodeService.generateQRCode("2"))
        ),
        Usuario(
            id = 3,
            nome = "Pedro Santos",
            email = "pedro@example.com",
            senha = "senha789",
            tipo = TipoUsuario.ADM,
            foto = "foto3.jpg",
            endereco = "Rua C",
            numero = 789,
            responsavelLegal = "Jose",
            qrCode = null
        )
    )

    private var idCont = 4L

    fun cadastrar(usuario: Usuario) {
        val novoId = idCont++
        val qrCodeImage = Base64.getEncoder().encodeToString(qrCodeService.generateQRCode(novoId.toString()))
        val usuarioComQrCode = if (usuario.tipo == TipoUsuario.ALUNO) {
            usuario.copy(id = novoId.toInt(), qrCode = qrCodeImage)
        } else {
            usuario.copy(id = novoId.toInt())
        }
        usuarios.add(usuarioComQrCode)
    }
    fun update(id: Long, usuarioAtualizado: Usuario) {
        val usuarioIndex = usuarios.indexOfFirst { it.id.toLong() == id }
        if (usuarioIndex != -1) {
            val qrCodeImage = Base64.getEncoder().encodeToString(qrCodeService.generateQRCode(id.toString()))
            val usuarioComQrCode = if (usuarioAtualizado.tipo == TipoUsuario.ALUNO) {
                usuarioAtualizado.copy(qrCode = qrCodeImage)
            } else {
                usuarioAtualizado.copy(qrCode = null)
            }
            usuarios[usuarioIndex] = usuarioComQrCode
        }
    }

    fun findAll(): List<Usuario> {
        return usuarios
    }

    fun deletar(id: Long) {
        val usuario = usuarios.firstOrNull { it.id.toLong() == id }
        usuario?.let {
            usuarios.remove(it)
        }
    }
}
