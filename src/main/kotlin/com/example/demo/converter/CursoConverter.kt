package com.example.demo.converter
import com.example.demo.dto.CursoDTO
import com.example.demo.dto.CursoResponseDTO
import com.example.demo.model.Curso
import org.springframework.stereotype.Component

@Component
class CursoConverter {
    fun toCurso(dto: CursoDTO): Curso {
        return Curso(
                id = dto.id,
                nome = dto.nome,
                descricao = dto.descricao,
                professor = dto.professor
        )
    }

    fun toCursoResponseDTO(curso: Curso): CursoResponseDTO {
        return CursoResponseDTO(
                id = curso.id,
                nome = curso.nome,
                descricao = curso.descricao,
                professor = curso.professor
        )
    }
}
