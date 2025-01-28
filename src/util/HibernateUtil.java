package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        SessionFactory tempSessionFactory = null;
        try {
            Configuration configuration = new Configuration();

            // Configurações do banco de dados
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/seu_banco_de_dados");
            configuration.setProperty("hibernate.connection.username", "seu_usuario");
            configuration.setProperty("hibernate.connection.password", "sua_senha");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

            // Outras configurações do Hibernate
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.show_sql", "true");

            // Registrar as entidades
            configuration.addAnnotatedClass(model.LivroModel.class);
            configuration.addAnnotatedClass(model.UsuarioModel.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            tempSessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
            System.err.println("Erro na inicialização do HibernateUtil: " + ex);
            ex.printStackTrace(); // Adicione este print para capturar mais detalhes
        }
        sessionFactory = tempSessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            throw new IllegalStateException("Falha ao inicializar o Hibernate SessionFactory.");
        }
        return sessionFactory;
    }
}
