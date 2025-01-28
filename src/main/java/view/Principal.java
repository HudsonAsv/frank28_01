package view;

import controller.LivroController;
import controller.UsuarioController;
import model.LivroModel;
import model.UsuarioModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Principal extends JFrame {
    public Principal() {
        setTitle("Sistema Biblioteca");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Botão Adicionar Livro
        JButton adicionarLivroButton = new JButton("Adicionar Livro");
        adicionarLivroButton.setBounds(50, 30, 150, 30);
        add(adicionarLivroButton);

        adicionarLivroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarLivro();
            }
        });

        // Botão Listar Livros
        JButton listarLivrosButton = new JButton("Listar Livros");
        listarLivrosButton.setBounds(210, 30, 150, 30);
        add(listarLivrosButton);

        listarLivrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarLivros();
            }
        });

        // Botão Adicionar Usuário
        JButton adicionarUsuarioButton = new JButton("Adicionar Usuário");
        adicionarUsuarioButton.setBounds(50, 80, 150, 30);
        add(adicionarUsuarioButton);

        adicionarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarUsuario();
            }
        });

        // Botão Listar Usuários
        JButton listarUsuariosButton = new JButton("Listar Usuários");
        listarUsuariosButton.setBounds(210, 80, 150, 30);
        add(listarUsuariosButton);

        listarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarUsuarios();
            }
        });

        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }

    private void adicionarLivro() {
        LivroController livroController = new LivroController();

        try {
            String titulo = JOptionPane.showInputDialog(this, "Digite o título do livro:");
            String autor = JOptionPane.showInputDialog(this, "Digite o autor do livro:");
            String isbnInput = JOptionPane.showInputDialog(this, "Digite o ISBN do livro:");
            long isbn = Long.parseLong(isbnInput); // Conversão para long

            if (titulo != null && autor != null) {
                livroController.adicionarLivro(titulo, autor, 0, "", isbn, null);
                JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ISBN inválido. Por favor, insira um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarLivros() {
        LivroController livroController = new LivroController();
        List<LivroModel> livros = livroController.listarLivros();

        StringBuilder sb = new StringBuilder("Livros cadastrados:\n");
        for (LivroModel livro : livros) {
            sb.append("Título: ").append(livro.getTitulo())
                    .append(", Autor: ").append(livro.getAutor())
                    .append(", ISBN: ").append(livro.getIsbn())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "Nenhum livro cadastrado.",
                "Lista de Livros", JOptionPane.INFORMATION_MESSAGE);
    }

    private void adicionarUsuario() {
        UsuarioController usuarioController = new UsuarioController();

        String nome = JOptionPane.showInputDialog(this, "Digite o nome do usuário:");
        String email = JOptionPane.showInputDialog(this, "Digite o email do usuário:");

        if (nome != null && email != null) {
            usuarioController.adicionarUsuario(nome, email);
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void listarUsuarios() {
        UsuarioController usuarioController = new UsuarioController();
        List<UsuarioModel> usuarios = usuarioController.listarUsuarios();

        StringBuilder sb = new StringBuilder("Usuários cadastrados:\n");
        for (UsuarioModel usuario : usuarios) {
            sb.append("Nome: ").append(usuario.getNome())
                    .append(", Email: ").append(usuario.getEmail())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "Nenhum usuário cadastrado.",
                "Lista de Usuários", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new Principal(); // Inicia a aplicação
    }
}
