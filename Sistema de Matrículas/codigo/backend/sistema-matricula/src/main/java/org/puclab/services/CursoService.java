package org.puclab.services;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.puclab.exceptions.ObjectNotFoundException;
import org.puclab.models.Curso;
import org.puclab.models.dtos.CursoDTO;

import java.util.List;

@ApplicationScoped
public class CursoService {

    public List<PanacheEntityBase> findAll(Integer page, Integer pageSize) {
        return Curso.findAll()
                .page(page, pageSize)
                .list();
    }


    public CursoDTO findById(Long id) {
        Curso curso = (Curso) Curso
                .findByIdOptional(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException("Curso não encontrado")
                );

        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setId(curso.getId());
        cursoDTO.setNome(curso.getNome());
        cursoDTO.setCreditos(curso.getCreditos());
        return cursoDTO;
    }

    public CursoDTO criarCurso(CursoDTO cursoDTO) {
        Curso novoCurso = new Curso();
        fromDTO(cursoDTO, novoCurso);
        return cursoDTO;
    }


    public CursoDTO atualizarCurso(CursoDTO cursoDTO, Long id) {
        Curso curso = Curso.findById(id);
        fromDTO(cursoDTO, curso);
        return cursoDTO;
    }

    private static void fromDTO(CursoDTO cursoDTO, Curso curso) {
        curso.setCreditos(cursoDTO.getCreditos());
        curso.setNome(cursoDTO.getNome());
        curso.persist();
        cursoDTO.setId(curso.getId());
    }

    public void deletarCurso(Long id) {
        Curso curso = Curso.findById(id);
        curso.delete();
    }
}
