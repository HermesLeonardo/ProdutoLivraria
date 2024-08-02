package br.edu.unifio.drogaria.repositorio.ProdutoRepositorio;

import br.edu.unifio.drogaria.entidades.Produto.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component

public class ProdutoRepositorio {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional

    public void inserir(Produto produto){

        entityManager.persist(produto);

    }


    public List<Produto> Listar(){


       Query consulta =  entityManager.createQuery("select p from Produto p order by p.nome");

       List<Produto> produtos = consulta.getResultList();

       return produtos;

    }

    @Transactional
    public void excluir(Integer codigo){

        Produto produto = entityManager.find(Produto.class, codigo);
        entityManager.remove(produto);



    }



}
