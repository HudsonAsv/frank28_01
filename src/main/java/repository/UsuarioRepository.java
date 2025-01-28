package repository;

import model.UsuarioModel;

import javax.persistence.*;
import java.util.List;

public class UsuarioRepository {
    private static final String PERSISTENCE_UNIT_NAME = "crudHibernatePU";
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public void salvar(UsuarioModel usuario) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<UsuarioModel> listarTodos() {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createQuery("FROM UsuarioModel", UsuarioModel.class).getResultList();
        } finally {
            em.close();
        }
    }
}
