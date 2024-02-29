package com.example.demo.repository

import com.example.demo.model.TipoUsuario
import com.example.demo.model.Usuario
import org.springframework.stereotype.Repository

@Repository
class UsuarioRepository {

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
                    responsavelLegal = "Jose"
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
                    responsavelLegal = "Jose"
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
                    responsavelLegal = "Jose"
            )
    )
    fun update(id: Long, usuarioAtualizado: Usuario) {
        val usuario = usuarios.first { it.id.toLong() == id }
        usuarios.remove(usuario)
        usuarios.add(
                Usuario(
                        id = usuarioAtualizado.id,
                        nome = usuarioAtualizado.nome,
                        email = usuarioAtualizado.email,
                        senha = usuarioAtualizado.senha,
                        tipo = usuarioAtualizado.tipo,
                        foto = usuarioAtualizado.foto,
                        endereco = usuarioAtualizado.endereco,
                        numero = usuarioAtualizado.numero,
                        responsavelLegal = usuarioAtualizado.responsavelLegal,

                )
        )
    }


    private var idCont = 4L
    private var idContInt: Int = idCont.toInt()

    fun cadastrar(usuario: Usuario) {
        usuarios.add(usuario.copy(id = idContInt++))
    }
    fun findAll(): List<Usuario> {
        return usuarios
    }
    fun deletar(id: Long) {
        val usuario = usuarios.first { it.id.toLong() == id }
        usuarios.remove(usuario)
    }
}
