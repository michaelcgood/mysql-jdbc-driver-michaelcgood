package com.michaelcgood.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.michaelcgood.dao.SystemRepository;

@SpringBootApplication
@EnableJpaRepositories("com.michaelcgood.dao")
@EntityScan("com.michaelcgood.model")
public class MysqlJdbcDriverApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSource;

	@Autowired
	SystemRepository systemRepository;

	public static void main(String[] args) {
		SpringApplication.run(MysqlJdbcDriverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Our DataSource is = " + dataSource);
		Iterable<com.michaelcgood.model.System> systemlist = systemRepository.findAll();
		for(com.michaelcgood.model.System systemmodel:systemlist){
			System.out.println("Here is a system: " + systemmodel.toString());
		}
		

	}

}
