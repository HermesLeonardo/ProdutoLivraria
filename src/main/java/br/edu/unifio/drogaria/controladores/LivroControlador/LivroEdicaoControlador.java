package br.edu.unifio.drogaria.controladores.LivroControlador;

import br.edu.unifio.drogaria.entidades.Livro.Livro;
import br.edu.unifio.drogaria.repositorio.LivroRepositorio.LivroRepositorio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
@Data
public class LivroEdicaoControlador {

    @Autowired
    private LivroRepositorio livroRepositorio;

    private Livro livro;


    @PostConstruct
    public void carregar(){

        // captura no escopo flash o objeto selecionado na tela de listagem
        livro = Faces.getFlashAttribute("selecionado");

    }


    public void editar(){


        livroRepositorio.editarLivro(livro.getCodigo(), livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getAnoDePublicacao());

        //mensagem
        Messages.addFlashGlobalInfo("O livro foi editado com sucesso");

        //redicionamento
        Faces.redirect("livro-listagem.xhtml");

    }

    public void cancelar(){

        Faces.redirect("livro-listagem.xhtml");
    }

}
