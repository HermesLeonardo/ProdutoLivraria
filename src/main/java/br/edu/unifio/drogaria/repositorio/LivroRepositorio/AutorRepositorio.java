package br.edu.unifio.drogaria.repositorio.LivroRepositorio;

import br.edu.unifio.drogaria.entidades.Livro.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutorRepositorio {

    @PersistenceContext
    private EntityManager entityManager;



    public List<Autor> listarAutor(){

        Query consultaAutor = entityManager.createQuery("select a from Autor a order by a.nome_autor");

        List<Autor> autors = consultaAutor.getResultList();

        return autors;


    }

}
