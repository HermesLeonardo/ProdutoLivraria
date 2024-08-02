package br.edu.unifio.drogaria.repositorio.ProdutoRepositorio;


import br.edu.unifio.drogaria.entidades.Produto.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaRepositorio {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Categoria> listar(){

        Query consulta = entityManager.createQuery("select  c from Categoria c order by c.nome");

        List<Categoria> categorias = consulta.getResultList();

        return categorias;
    }

}
