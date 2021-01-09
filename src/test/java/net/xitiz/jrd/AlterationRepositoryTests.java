package net.xitiz.jrd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import net.xitiz.jrd.repositories.AlterationRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JrdApplication.class)
public class AlterationRepositoryTests {

    @Autowired
    AlterationRepository repo;

    @Test
    void findById() {
        System.out.println("======== Test Running ====== ");
        var item = repo.findById(2);
        assertEquals("Alteration-2", item.get().getName());
    }

}
