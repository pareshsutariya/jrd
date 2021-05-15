
package net.xitiz.jrd.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.xitiz.jrd.repositories.AlterationRepository;
import net.xitiz.jrd.entities.*;
import net.xitiz.jrd.exceptions.AlterationNotFoundException;

@RestController
@RequestMapping("/api/alterations")
public class AlterationRestController {

    @Autowired
    AlterationRepository repo;

    @GetMapping()
    public List<Alteration> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Alteration findById(@PathVariable int id) {
        var item = repo.findById(id);

        if (!item.isPresent())
            throw new AlterationNotFoundException("Alteration with given id " + id + " not found");

        return item.get();
    }

    @PostMapping()
    public Alteration save(@RequestBody Alteration alt) {
        return repo.save(alt);
    }

    @PutMapping("/{id}")
    public Alteration save(@PathVariable int id, @RequestBody Alteration alt) {
        return repo.save(alt);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        var item = repo.findById(id);
        if (!item.isPresent())
            throw new AlterationNotFoundException("Alteration with given id " + id + " not found");
        repo.deleteById(id);
    }
}
