package org.puclab.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfessorResponseDTO {
    private Long id;
    private String nome;
    private List<DisciplinaDTO> disciplinas;
}
