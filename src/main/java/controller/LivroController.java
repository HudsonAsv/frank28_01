package controller;

import model.LivroModel;
import repository.LivroRepository;

import java.util.List;

public class LivroController {
    private LivroRepository repository = new LivroRepository();

    public void adicionarLivro(String titulo, String autor, int paginas, String descricao, int isbn, String data) {
        LivroModel livro = new LivroModel();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setQuantidade(paginas);
        livro.setDescricao(descricao);
        livro.setIsbn(isbn);
        livro.setData(data);
        repository.salvar(livro);
    }

    public List<LivroModel> listarLivros() {
        return repository.listarTodos();
    }
}