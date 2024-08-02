
package br.edu.unifio.drogaria.entidades.Livro;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data

public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer codigo;

    private String Titulo;

    private LocalDate AnoDePublicacao;


    @ManyToOne
    private Editora editora;

    @ManyToOne
    private Autor autor;




}
