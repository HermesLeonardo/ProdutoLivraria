package br.edu.unifio.drogaria.controladores.LivroControlador;


import br.edu.unifio.drogaria.entidades.Livro.Autor;
import br.edu.unifio.drogaria.entidades.Livro.Editora;
import br.edu.unifio.drogaria.entidades.Livro.Livro;

import br.edu.unifio.drogaria.repositorio.LivroRepositorio.AutorRepositorio;
import br.edu.unifio.drogaria.repositorio.LivroRepositorio.EditoraRepositorio;
import br.edu.unifio.drogaria.repositorio.LivroRepositorio.LivroRepositorio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@ViewScoped
@Data
@ComponentScan
@Repository

public class LivroControlador {

    @Autowired
    private AutorRepositorio autorRepositorio;
    private List<Autor> autors;


    @Autowired
    private EditoraRepositorio editoraRepositorio;
    private List<Editora> editoras;


    @Autowired
    private LivroRepositorio livroRepositorio;
    private Livro livro;




    @PostConstruct
        public void novo(){

        livro = new Livro();

        autors = autorRepositorio.listarAutor();
        editoras = editoraRepositorio.listarEditora();
    }

    public void salvar(){

        livroRepositorio.inserirLivro(livro);

        livro = new Livro();

        autors = autorRepositorio.listarAutor();
        editoras = editoraRepositorio.listarEditora();

        Messages.addFlashGlobalInfo("Registro salvo com sucesso");
    }

    public void  voltar(){

        Faces.redirect("livro-listagem.xhtml");


    }




}
