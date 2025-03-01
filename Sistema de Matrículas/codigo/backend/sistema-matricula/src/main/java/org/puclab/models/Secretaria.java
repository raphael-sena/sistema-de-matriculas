package org.puclab.models;

import jakarta.persistence.*;
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
public class Secretaria extends Usuario {

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "secretaria_id")
    public Set<Usuario> usuarios;

    public Secretaria(String nome, String senha, String tipo) {
        super(nome, senha, tipo);
    }
}
