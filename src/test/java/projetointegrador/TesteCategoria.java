package projetointegrador;

import java.sql.SQLException;
import java.util.List;

import br.com.senaisp.bauru.factory.DatabaseMigration;
import br.com.senaisp.bauru.model.Categoria;
import br.com.senaisp.bauru.service.CategoriaService;

public class TesteCategoria {

    public static void main(String[] args) {
        DatabaseMigration.executar();
        CategoriaService service = new CategoriaService();

        try {
            service.cadastrar(new Categoria("Filme"));
            service.cadastrar(new Categoria("Série"));
            service.cadastrar(new Categoria("Documentário"));

            System.out.println("Categorias cadastradas!");

            List<Categoria> lista = service.listar();
            System.out.println("\n--- Lista de Categorias ---");
            for (Categoria c : lista) {
                System.out.println(c);
            }

            System.out.println("\n--- Testando validação duplicada ---");
            try {
                service.cadastrar(new Categoria("Filme"));
            } catch (IllegalArgumentException e) {
                System.out.println("Erro esperado: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.err.println("Erro no banco: " + e.getMessage());
        }
    }
}