
package net.xitiz.jrd.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
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
        var item = repo.findById(id)
                .orElseThrow(() -> new AlterationNotFoundException("Alteration with given id " + id + " not found"));

        return item;
    }

    @PostMapping()
    public Alteration save(@RequestBody Alteration alt) {
        try {
            return repo.save(alt);
        } catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }
    }

    @PutMapping("/{id}")
    public Alteration save(@PathVariable int id, @RequestBody Alteration alt) {
        try {
            return repo.save(alt);
        } catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        var item = repo.findById(id)
                .orElseThrow(() -> new AlterationNotFoundException("Alteration with given id " + id + " not found"));

        repo.delete(item);
    }
}
