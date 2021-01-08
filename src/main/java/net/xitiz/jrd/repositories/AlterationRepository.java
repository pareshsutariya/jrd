package net.xitiz.jrd.repositories;

import java.util.List;

import javax.transaction.Transactional;
import net.xitiz.jrd.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AlterationRepository extends JpaRepository<Alteration, Integer> {
    public List<Alteration> findAllByIsDeleted(boolean isDeleted);
}
