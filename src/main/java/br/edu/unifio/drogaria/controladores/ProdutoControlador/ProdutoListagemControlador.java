package br.edu.unifio.drogaria.controladores.ProdutoControlador;


import br.edu.unifio.drogaria.entidades.Produto.Produto;
import br.edu.unifio.drogaria.repositorio.ProdutoRepositorio.ProdutoRepositorio;
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

public class ProdutoListagemControlador {

    private List<Produto> produtos;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;


    @PostConstruct
    public void listar(){
        produtos = produtoRepositorio.Listar();

    }

    public void excluir(Produto produto){

        // Armazena o objeto selecionado no escopo flash
        Faces.setFlashAttribute("selecionado", produto);

        //Redireciona para pagina informada
        Faces.redirect("produto-exclusao.xhtml");

    }

}
