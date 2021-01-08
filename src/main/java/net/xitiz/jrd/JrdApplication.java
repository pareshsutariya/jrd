package net.xitiz.jrd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.xitiz.jrd.entities.Alteration;
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

		System.out.println("\n=== Adding Alt1 ===");
		var alt1 = altRepo.save(new Alteration("Alteration-1"));
		System.out.println("\tAlt1 Saved : " + alt1.toString());

		System.out.println("\n=== Adding Alt2 ===");
		var alt2 = altRepo.save(new Alteration("Alteration-2"));
		System.out.println("\tAlt2 Saved : " + alt2.toString());

		System.out.println("\n=== Adding Alt3 ===");
		var alt3 = altRepo.save(new Alteration("Alteration-3"));
		System.out.println("\tAtl3 Saved : " + alt3.toString());

		System.out.println("\n=== Adding Alt4 ===");
		var alt4 = altRepo.save(new Alteration("Alteration-4"));
		System.out.println("\tAlt4 Saved : " + alt4.toString());

		System.out.println("\n=== Update Alt1 ===");
		alt1.setName("Alteration-1 updated");
		alt1.setIsDeleted(true);
		var alt1Updated = altRepo.save(alt1);
		System.out.println("\tAlt1 Updated : " + alt1Updated.toString());

		System.out.println("\n=== Delete Alt4 ===");
		altRepo.delete(alt4);
		System.out.println("\tAlt4 Deleted successfully");

		System.out.println("\n=== FindAll ===");
		var all = altRepo.findAll();
		System.out.println("\tFindAll Result : " + all.toString());

		System.out.println("\n=== FindAllByIsDeleted(true) ===");
		var allByIsDeleted = altRepo.findAllByIsDeleted(true);
		System.out.println("\tFindAllByIsDeleted(true) Result : " + allByIsDeleted);

		System.out.println("\n=== FindAllByIsDeleted(false) ===");
		var allByIsNotDeleted = altRepo.findAllByIsDeleted(false);
		System.out.println("\tFindAllByDeleted(false) Result : " + allByIsNotDeleted);
	}
}
