package br.edu.unifio.drogaria.controladores.LivroControlador;


import br.edu.unifio.drogaria.entidades.Livro.Livro;
import br.edu.unifio.drogaria.repositorio.LivroRepositorio.LivroRepositorio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data

public class LivroListagemControlador {

    private List<Livro> livros;

    @Autowired
    private LivroRepositorio livroRepositorio;


    @PostConstruct

    public void listar(){


        livros = livroRepositorio.ListarLivro();

    }

    public void excluir(Livro livro){

        // Armazena o objeto selecionado no escopo flash
        Faces.setFlashAttribute("selecionado", livro);

        //Redireciona para pagina informada
        Faces.redirect("livro-exclusao.xhtml");

    }

    public void editar(Livro livro){

        // Armazena o objeto selecionado no escopo flash
        Faces.setFlashAttribute("selecionado", livro);

        //Redireciona para pagina informada
        Faces.redirect("livro-edicao.xhtml");

    }

}
