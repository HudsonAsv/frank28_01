package repository;

import model.LivroModel;
import javax.persistence.*;
import java.util.List;

public class LivroRepository {
    private static final String PERSISTENCE_UNIT_NAME = "crudHibernatePU";
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public void salvar(LivroModel livro) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(livro);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<LivroModel> listarTodos() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createQuery("FROM LivroModel", LivroModel.class).getResultList();
        } finally {
            em.close();
        }
    }
}
