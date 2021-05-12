package net.xitiz.jrd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.xitiz.jrd.repositories.AlterationRepository;

@SpringBootApplication
public class JrdApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JrdApplication.class, args);
	}

	@Autowired
	AlterationRepository altRepo;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("====== Welcome from Java World !!=======");
		System.out.println("====== Hello.....from JRD portal =======");
	
	}
}
