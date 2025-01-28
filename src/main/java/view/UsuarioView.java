package view;

import controller.UsuarioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioView extends JFrame {
    public UsuarioView() {
        setTitle("Gerenciar Usuários");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Campos de entrada
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 20, 80, 25);
        add(nomeLabel);

        JTextField nomeText = new JTextField(20);
        nomeText.setBounds(100, 20, 165, 25);
        add(nomeText);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 50, 80, 25);
        add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(100, 50, 165, 25);
        add(emailText);

        JButton addButton = new JButton("Adicionar Usuário");
        addButton.setBounds(10, 100, 150, 25);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeText.getText();
                    String email = emailText.getText();

                    UsuarioController controller = new UsuarioController();
                    controller.adicionarUsuario(nome, email);

                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao adicionar usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}
