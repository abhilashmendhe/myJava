package com.abhitrio.database_postgres;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@SpringBootApplication
@Log
public class DatabasePostgresApplication implements CommandLineRunner {

	public DataSource dataSource;

	public DatabasePostgresApplication(final DataSource dataSource){
		this.dataSource = dataSource;
	}
	public static void main(String[] args) {
		SpringApplication.run(DatabasePostgresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Datsource: "+dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}
