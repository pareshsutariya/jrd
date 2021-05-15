package net.xitiz.jrd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JrdApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JrdApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		System.out.println("====== Welcome from Java World !!=======");
		System.out.println("====== Hello.....from JRD portal =======");
	
	}
}
