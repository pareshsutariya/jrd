package net.xitiz.jrd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import net.xitiz.jrd.entities.Alteration;
import net.xitiz.jrd.repositories.AlterationRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JrdApplication.class)
public class AlterationRepositoryTests {

    @Autowired
    AlterationRepository repo;

    @Test
    void sanityTest() {
        System.out.println("\n=== SANITY TESTS ===");
        System.out.println("\n=== Adding Alt1 ===");
        var alt1 = repo.save(new Alteration("Alteration-1"));
        System.out.println("\tAlt1 Saved : " + alt1.toString());
        assertTrue(alt1.getId() > 0);

        System.out.println("\n=== Adding Alt2 ===");
        var alt2 = repo.save(new Alteration("Alteration-2"));
        System.out.println("\tAlt2 Saved : " + alt2.toString());
        assertTrue(alt2.getId() > 0);

        System.out.println("\n=== Adding Alt3 ===");
        var alt3 = repo.save(new Alteration("Alteration-3"));
        System.out.println("\tAtl3 Saved : " + alt3.toString());
        assertTrue(alt3.getId() > 0);

        System.out.println("\n=== Adding Alt4 ===");
        var alt4 = repo.save(new Alteration("Alteration-4"));
        System.out.println("\tAlt4 Saved : " + alt4.toString());
        assertTrue(alt4.getId() > 0);

        System.out.println("\n=== Update Alt1 ===");
        alt1.setName("Alteration-1 updated");
        alt1.setIsDeleted(true);
        var alt1Updated = repo.save(alt1);
        System.out.println("\tAlt1 Updated : " + alt1Updated.toString());
        assertEquals("Alteration-1 updated", alt1Updated.getName());

        System.out.println("\n=== Delete Alt4 ===");
        repo.delete(alt4);
        System.out.println("\tAlt4 Deleted successfully");

        System.out.println("\n=== FindAll ===");
        var all = repo.findAll();
        System.out.println("\tFindAll Result : " + all.toString());
        assertTrue(all.size() > 0);

        System.out.println("\n=== FindAllByIsDeleted(true) ===");
        var allByIsDeleted = repo.findAllByIsDeleted(true);
        System.out.println("\tFindAllByIsDeleted(true) Result : " + allByIsDeleted);
        assertTrue(allByIsDeleted.size() > 0);

        System.out.println("\n=== FindAllByIsDeleted(false) ===");
        var allByIsNotDeleted = repo.findAllByIsDeleted(false);
        System.out.println("\tFindAllByDeleted(false) Result : " + allByIsNotDeleted);
        assertTrue(allByIsNotDeleted.size() > 0);

    }

    @Test
    void findById() {
        System.out.println("======== Test Running ====== ");
        var item = repo.findById(2);
        assertEquals("Alteration-2", item.get().getName());
    }

}
