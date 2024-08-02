package br.edu.unifio.drogaria.repositorio.LivroRepositorio;

import br.edu.unifio.drogaria.entidades.Livro.Autor;
import br.edu.unifio.drogaria.entidades.Livro.Editora;
import br.edu.unifio.drogaria.entidades.Livro.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.Data;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component

public class LivroRepositorio {


    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void inserirLivro(Livro livro){

        entityManager.persist(livro);

    }


    public List<Livro> ListarLivro(){


        Query consulta =  entityManager.createQuery("select l from Livro l order by l.Titulo");

        List<Livro> livros = consulta.getResultList();

        return livros;

    }

    @Transactional
    public void excluirLivro(Integer codigo){

        Livro livro = entityManager.find(Livro.class, codigo);
        entityManager.remove(livro);



    }

    @Transactional
    public void editarLivro(Integer codigo, String titulo, Autor autor, Editora editora, LocalDate anoDePublicacao) {



        Query editar = entityManager.createQuery("update Livro l set l.Titulo = ?1, l.AnoDePublicacao = ?2, l.autor = ?3, l.editora = ?4 where l.codigo = ?5");

        editar.setParameter(5,codigo);
        editar.setParameter(1,titulo);
        editar.setParameter(2,anoDePublicacao);
        editar.setParameter(3, autor);
        editar.setParameter(4, editora);

        editar.executeUpdate();


    }
}
