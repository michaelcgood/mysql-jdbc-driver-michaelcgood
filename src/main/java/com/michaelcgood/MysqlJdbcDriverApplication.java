package com.michaelcgood;

import java.sql.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.michaelcgood.dao.SystemRepository;
import com.michaelcgood.model.SystemExample;

@SpringBootApplication
@EnableJpaRepositories("com.michaelcgood.dao")
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
		// add windows server
		SystemExample systemExampleWindows = new SystemExample();
		systemExampleWindows.setName("Windows Server 2012 R2");
		systemExampleWindows.setLastaudit("2017-08-11");
		systemRepository.save(systemExampleWindows);
		// add rhel
		SystemExample systemExampleRhel = new SystemExample();
		systemExampleRhel.setName("RHEL 7");
		systemExampleRhel.setLastaudit("2017-07-21");
		systemRepository.save(systemExampleRhel);
		// add solaris
		SystemExample systemExampleSolaris = new SystemExample();
		systemExampleSolaris.setName("Solaris 11");
		systemExampleSolaris.setLastaudit("2017-08-13");
		systemRepository.save(systemExampleSolaris);
		Iterable<SystemExample> systemlist = systemRepository.findAll();
		System.out.println("here are system count: " + systemlist.toString());
		for(SystemExample systemExample:systemlist){
			System.out.println("Here is a system: " + systemExample.toString());
		}
		

	}

}
