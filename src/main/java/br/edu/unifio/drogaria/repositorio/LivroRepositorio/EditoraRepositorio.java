package br.edu.unifio.drogaria.repositorio.LivroRepositorio;


import br.edu.unifio.drogaria.entidades.Livro.Editora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditoraRepositorio {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Editora> listarEditora(){

        Query consultaEditora = entityManager.createQuery("select e from Editora e order by e.nomeFantasma");

        List<Editora> editoras = consultaEditora.getResultList();

        return editoras;


    }

}
