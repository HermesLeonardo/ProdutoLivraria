package br.edu.unifio.drogaria.controladores.ProdutoControlador;


import br.edu.unifio.drogaria.entidades.Produto.Categoria;
import br.edu.unifio.drogaria.entidades.Produto.Produto;
import br.edu.unifio.drogaria.repositorio.ProdutoRepositorio.CategoriaRepositorio;
import br.edu.unifio.drogaria.repositorio.ProdutoRepositorio.ProdutoRepositorio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ViewScoped
@Data
@ComponentScan

public class ProdutoControlador {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    private List<Categoria> categorias;


    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    private Produto produto;






    @PostConstruct
    public void novo(){
        produto = new Produto();
        categorias = categoriaRepositorio.listar();
    }

    public void salvar() {

        produtoRepositorio.inserir(produto);

        produto = new Produto();
        categorias = categoriaRepositorio.listar();


        Messages.addFlashGlobalInfo("Registro salvo com sucesso");
    }
}






