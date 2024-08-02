package br.edu.unifio.drogaria.entidades.Livro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer codigo;

    private String nome_autor;
}
