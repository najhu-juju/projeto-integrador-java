package br.com.senaisp.bauru.service;

import java.sql.SQLException;
import java.util.List;

import br.com.senaisp.bauru.dao.CategoriaDAO;
import br.com.senaisp.bauru.model.Categoria;

public class CategoriaService {

    private CategoriaDAO categoriaDAO = new CategoriaDAO();

    public void cadastrar(Categoria categoria) throws SQLException {
        // Validação 1: Nome obrigatório
        if (categoria.getNome() == null || categoria.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da categoria é obrigatório.");
        }

        // Validação 2: Nome com no mínimo 3 caracteres
        if (categoria.getNome().trim().length() < 3) {
            throw new IllegalArgumentException("O nome da categoria deve ter no mínimo 3 caracteres.");
        }

        // Validação 3: Não permitir duplicadas
        List<Categoria> existentes = categoriaDAO.listarTodas();
        for (Categoria c : existentes) {
            if (c.getNome().equalsIgnoreCase(categoria.getNome().trim())) {
                throw new IllegalArgumentException("Já existe uma categoria com esse nome.");
            }
        }

        categoriaDAO.salvar(categoria);
    }

    public List<Categoria> listar() throws SQLException {
        return categoriaDAO.listarTodas();
    }

    public Categoria buscar(int id) throws SQLException {
        return categoriaDAO.buscarPorId(id);
    }

    public void atualizar(Categoria categoria) throws SQLException {
        if (categoria.getIdCategoria() <= 0) {
            throw new IllegalArgumentException("ID inválido para atualização.");
        }
        categoriaDAO.atualizar(categoria);
    }

    public void deletar(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
        categoriaDAO.deletar(id);
    }
}