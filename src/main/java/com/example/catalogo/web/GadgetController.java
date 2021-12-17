/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.web;

import com.example.catalogo.modelo.Gadget;
import com.example.catalogo.servicios.GadgetService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL - PC
 */
@RestController
@RequestMapping("api/gadget")
@CrossOrigin
public class GadgetController {
    @Autowired
    private GadgetService service;
    
    @GetMapping("/all")
    public List<Gadget> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Gadget> getById(@PathVariable("id") int id) {
        return service.getById(id);
    }
    
    @GetMapping("/price/{precio}")
    public List<Gadget> getByPrice(@PathVariable("precio") Double price) {
        return service.getByPrice(price);
    }
    
    @GetMapping("/description/{texto}")
    public List<Gadget> getByDesc(@PathVariable("texto") String desc) {
        return service.getByDesc(desc);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget save(@RequestBody Gadget gadget) {
        return service.save(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget update(@RequestBody Gadget gadget) {
        return service.update(gadget);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int idGadget) {
        service.delete(idGadget);
    }
}
