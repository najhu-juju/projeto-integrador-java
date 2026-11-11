package br.com.senaisp.bauru.service;

import java.sql.SQLException;
import java.util.List;

import br.com.senaisp.bauru.dao.ClienteDAO;
import br.com.senaisp.bauru.model.Cliente;

public class ClienteService {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public void cadastrar(Cliente cliente) throws SQLException {
        // Validação 1: Nome não pode ser vazio
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente é obrigatório.");
        }

        // Validação 2: Telefone não pode ser vazio
        if (cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()) {
            throw new IllegalArgumentException("O telefone do cliente é obrigatório.");
        }

        // Validação 3: Email precisa ter um formato básico válido (@ e .)
        if (cliente.getEmail() == null || !cliente.getEmail().contains("@") || !cliente.getEmail().contains(".")) {
            throw new IllegalArgumentException("O e-mail informado é inválido.");
        }

        clienteDAO.salvar(cliente);
    }

    public List<Cliente> listar() throws SQLException {
        return clienteDAO.listarTodos();
    }

    public Cliente buscar(int id) throws SQLException {
        return clienteDAO.buscarPorId(id);
    }

    public void atualizar(Cliente cliente) throws SQLException {
        if (cliente.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido para atualização.");
        }
        clienteDAO.atualizar(cliente);
    }

    public void deletar(int id) throws SQLException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão.");
        }
        clienteDAO.deletar(id);
    }
}