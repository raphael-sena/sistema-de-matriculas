package org.puclab.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class Aluno extends Usuario {

    @OneToMany(mappedBy = "aluno", orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<Matricula> matriculas;

    public Aluno(String nome, String senha, String tipo) {
        super(nome, senha, tipo);
    }
}
