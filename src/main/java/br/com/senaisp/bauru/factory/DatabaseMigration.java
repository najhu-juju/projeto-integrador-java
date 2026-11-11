package br.com.senaisp.bauru.factory;

import org.flywaydb.core.Flyway;

public class DatabaseMigration {
	public static void executar () {
	Flyway flyway = Flyway.configure().dataSource(
			"jdbc:sqlite:database/pi.db",
			"root",
			"").load();
	flyway.migrate();
	}
}
