package projetointegrador;

import br.com.senaisp.bauru.factory.DatabaseMigration;

public class TesteMigration {

	public static void main(String[] args) {
		DatabaseMigration.executar();
		System.out.println("Banco de dados atualizado!");

	}

}
