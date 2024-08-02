package br.edu.unifio.drogaria.controladores.ProdutoControlador;

import br.edu.unifio.drogaria.entidades.Produto.Produto;
import br.edu.unifio.drogaria.repositorio.ProdutoRepositorio.ProdutoRepositorio;
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
public class ProdutoExclusaoControlador {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;


    private Produto produto;

    @PostConstruct
    public void carregar(){

        // captura no escopo flash o objeto selecionado na tela de listagem
        produto = Faces.getFlashAttribute("selecionado");

    }

    public void excluir(){

        //remove
        produtoRepositorio.excluir(produto.getCodigo());

        //mensagem
        Messages.addFlashGlobalInfo("O Produto foi excluido ");

        //redicionamento
        Faces.redirect("produto-listagem.xhtml");
    }


}
