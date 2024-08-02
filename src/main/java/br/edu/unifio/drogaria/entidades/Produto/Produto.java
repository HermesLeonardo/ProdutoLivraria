package br.edu.unifio.drogaria.entidades.Produto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity

public class Produto  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer codigo;
    private String nome;
    private Integer quantidade;
    private Double preco;
    private LocalDate validade;


    @ManyToOne
    private Categoria categoria;
}
