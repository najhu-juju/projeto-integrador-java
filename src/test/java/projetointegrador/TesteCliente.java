package projetointegrador;

import java.sql.SQLException;
import java.util.List;

import br.com.senaisp.bauru.model.Cliente;
import br.com.senaisp.bauru.service.ClienteService;

public class TesteCliente {

    public static void main(String[] args) {
        ClienteService service = new ClienteService();

        try {
            // Cadastrando 3 clientes
            Cliente c1 = new Cliente("Alice Silva", "14999990001", "alice@email.com");
            Cliente c2 = new Cliente("Bruno Souza", "14999990002", "bruno@email.com");
            Cliente c3 = new Cliente("Carla Mendes", "14999990003", "carla@email.com");

            service.cadastrar(c1);
            service.cadastrar(c2);
            service.cadastrar(c3);

            System.out.println("Clientes cadastrados com sucesso!");

            // Listando todos
            List<Cliente> clientes = service.listar();
            System.out.println("\n--- Lista de Clientes ---");
            for (Cliente c : clientes) {
                System.out.println(c);
            }

            // Testando validação (email inválido)
            System.out.println("\n--- Testando validação de email ---");
            try {
                Cliente invalido = new Cliente("Teste", "14000000000", "email_invalido");
                service.cadastrar(invalido);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro esperado: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Erro no banco: " + e.getMessage());
        }
    }
}