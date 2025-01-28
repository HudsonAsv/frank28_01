package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    public Principal() {
        setTitle("Sistema Biblioteca");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Botão Livros
        JButton livrosButton = new JButton("Gerenciar Livros");
        livrosButton.setBounds(50, 50, 200, 30);
        add(livrosButton);

        livrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LivroView();
            }
        });

        // Botão Usuários
        JButton usuariosButton = new JButton("Gerenciar Usuários");
        usuariosButton.setBounds(50, 100, 200, 30);
        add(usuariosButton);

        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UsuarioView();
            }
        });

        setVisible(true);
    }
}
