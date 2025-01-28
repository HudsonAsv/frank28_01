package controller;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;
import model.UsuarioModel;
import repository.UsuarioRepository;

import java.util.List;

public class UsuarioController {
    private UsuarioRepository repository = new UsuarioRepository();

    public void adicionarUsuario(String nome, String email) {
        if (nome == null || nome.isEmpty() || email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Nome e email são obrigatórios.");
        }
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(nome);
        usuario.setEmail(email);
        repository.salvar(usuario);
    }

    public List<UsuarioModel> listarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<UsuarioModel> query = session.createQuery("FROM UsuarioModel", UsuarioModel.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
