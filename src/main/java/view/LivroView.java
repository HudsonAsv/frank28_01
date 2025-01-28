package view;

import controller.LivroController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroView extends JFrame {
    public LivroView() {
        setTitle("Gerenciar Livros");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Campos de entrada
        JLabel tituloLabel = new JLabel("Título:");
        tituloLabel.setBounds(10, 20, 80, 25);
        add(tituloLabel);

        JTextField tituloText = new JTextField(20);
        tituloText.setBounds(100, 20, 165, 25);
        add(tituloText);

        JLabel autorLabel = new JLabel("Autor:");
        autorLabel.setBounds(10, 50, 80, 25);
        add(autorLabel);

        JTextField autorText = new JTextField(20);
        autorText.setBounds(100, 50, 165, 25);
        add(autorText);

        JLabel paginasLabel = new JLabel("Páginas:");
        paginasLabel.setBounds(10, 80, 80, 25);
        add(paginasLabel);

        JTextField paginasText = new JTextField(20);
        paginasText.setBounds(100, 80, 165, 25);
        add(paginasText);

        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoLabel.setBounds(10, 110, 80, 25);
        add(descricaoLabel);

        JTextField descricaoText = new JTextField(20);
        descricaoText.setBounds(100, 110, 165, 25);
        add(descricaoText);

        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setBounds(10, 140, 80, 25);
        add(isbnLabel);

        JTextField isbnText = new JTextField(20);
        isbnText.setBounds(100, 140, 165, 25);
        add(isbnText);

        JLabel dataLabel = new JLabel("Data:");
        dataLabel.setBounds(10, 170, 80, 25);
        add(dataLabel);

        JTextField dataText = new JTextField(20);
        dataText.setBounds(100, 170, 165, 25);
        add(dataText);

        JButton addButton = new JButton("Adicionar Livro");
        addButton.setBounds(10, 210, 150, 25);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String titulo = tituloText.getText();
                    String autor = autorText.getText();
                    int paginas = Integer.parseInt(paginasText.getText());
                    String descricao = descricaoText.getText();
                    int isbn = Integer.parseInt(isbnText.getText());
                    String data = dataText.getText();

                    LivroController controller = new LivroController();
                    controller.adicionarLivro(titulo, autor, paginas, descricao, isbn, data);

                    JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Valores inválidos para Páginas ou ISBN.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}
