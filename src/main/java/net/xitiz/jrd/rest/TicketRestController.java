package net.xitiz.jrd.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.xitiz.jrd.entities.Ticket;
import net.xitiz.jrd.repositories.TicketRepository;

@RestController
@RequestMapping("/api/tickets")
public class TicketRestController {

    @Autowired
    TicketRepository repo;

    @GetMapping()
    public List<Ticket> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Ticket findById(@PathVariable int id) throws Exception {
        var entity = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Ticket not found for the given id : " + id));

        return entity;
    }

    @PostMapping()
    public Ticket post(@RequestBody Ticket ticket) {
        return repo.save(ticket);
    }

    @PutMapping("/{id}")
    public Ticket put(@PathVariable int id, @RequestBody Ticket ticket) {
        return repo.save(ticket);
    }

    @DeleteMapping("/{id}") 
    public void delete(@PathVariable int id) throws Exception {
        var item = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Ticket not found for the given id : " + id));
        
        repo.delete(item);
    }
}