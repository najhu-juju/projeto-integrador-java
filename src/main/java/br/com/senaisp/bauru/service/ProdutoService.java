package br.com.senaisp.bauru.service;

import java.sql.SQLException;
import java.util.List;

import br.com.senaisp.bauru.dao.ProdutoDAO;
import br.com.senaisp.bauru.model.Produto;

public class ProdutoService {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public void cadastrar(Produto produto) throws SQLException {
        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório.");
        }
        if (produto.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        if (produto.getQuantidade() < 0) {
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");
        }
        if (produto.getIdCategoria() <= 0) {
            throw new IllegalArgumentException("A categoria é obrigatória.");
        }
        produtoDAO.salvar(produto);
    }

    public List<Produto> listar() throws SQLException {
        return produtoDAO.listarTodos();
    }

    public Produto buscar(int id) throws SQLException {
        return produtoDAO.buscarPorId(id);
    }

    public void atualizar(Produto produto) throws SQLException {
        if (produto.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido para atualização.");
        }
        produtoDAO.atualizar(produto);
    }

    public void deletar(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
        produtoDAO.deletar(id);
    }
}
