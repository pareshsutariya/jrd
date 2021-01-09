package net.xitiz.jrd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.xitiz.jrd.repositories.AlterationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JrdApplication.class)
public class AlterationRepositoryTests {

    @Autowired
    AlterationRepository repo;

    @Test
    void findById() {
        System.out.println("======== Test Running ====== ");
        var item = repo.findById(1);
        assertEquals(true, item.isPresent());
    }

}
