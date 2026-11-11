package projetointegrador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senaisp.bauru.factory.DatabaseMigration;
import br.com.senaisp.bauru.model.Categoria;
import br.com.senaisp.bauru.model.Produto;
import br.com.senaisp.bauru.service.CategoriaService;
import br.com.senaisp.bauru.service.ProdutoService;

public class TesteProdutoService {

    public static void main(String[] args) {
        // Garante que as tabelas existem
        DatabaseMigration.executar();

        ProdutoService service = new ProdutoService();
        CategoriaService categoriaService = new CategoriaService();
        List<Produto> inseridos = new ArrayList<>();

        try {
            // Garante que existe pelo menos uma categoria
            List<Categoria> categorias = categoriaService.listar();
            if (categorias.isEmpty()) {
                System.out.println("Nenhuma categoria encontrada. Cadastrando categoria padrão...");
                categoriaService.cadastrar(new Categoria("Geral"));
                categorias = categoriaService.listar();
            }
            int idCategoria = categorias.get(0).getIdCategoria();
            System.out.println("Usando categoria id=" + idCategoria +
                               " (" + categorias.get(0).getNome() + ")\n");

            // ========== 1) INCLUIR 6 REGISTROS ==========
            System.out.println("=== INCLUINDO 6 PRODUTOS ===");
            String[] nomes = {"Mouse", "Teclado", "Monitor", "Headset", "Webcam", "Mousepad"};
            double[] precos = {50.0, 120.0, 900.0, 200.0, 150.0, 30.0};

            for (int i = 0; i < 6; i++) {
                Produto p = new Produto(nomes[i], precos[i], 10 + i, idCategoria);
                service.cadastrar(p);
                inseridos.add(p);
                System.out.println("Inserido: " + p);
            }

            // ========== 2) ALTERAR 3 REGISTROS ==========
            System.out.println("\n=== ALTERANDO 3 PRODUTOS ===");
            for (int i = 0; i < 3; i++) {
                Produto p = inseridos.get(i);
                p.setNome(p.getNome() + " Atualizado");
                p.setPreco(p.getPreco() + 10);
                service.atualizar(p);
                System.out.println("Alterado: " + p);
            }

            // ========== 3) LISTAR TODOS ==========
            System.out.println("\n=== LISTANDO TODOS OS PRODUTOS ===");
            List<Produto> todos = service.listar();
            for (Produto p : todos) {
                System.out.println(p);
            }

            // ========== 4) APAGAR 3 REGISTROS ==========
            System.out.println("\n=== APAGANDO 3 PRODUTOS ===");
            for (int i = 3; i < 6; i++) {
                Produto p = inseridos.get(i);
                service.deletar(p.getId());
                System.out.println("Apagado id=" + p.getId() + " (" + p.getNome() + ")");
            }

            // Lista final
            System.out.println("\n=== LISTA FINAL ===");
            for (Produto p : service.listar()) {
                System.out.println(p);
            }

            System.out.println("\nTeste concluído com sucesso!");

        } catch (SQLException | IllegalArgumentException e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
