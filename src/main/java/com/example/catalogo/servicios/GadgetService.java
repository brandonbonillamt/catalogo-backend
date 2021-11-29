/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.servicios;

import com.example.catalogo.modelo.Gadget;
import com.example.catalogo.repositorios.GadgetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL - PC
 */
@Service
public class GadgetService {
    
    @Autowired
    private GadgetRepository repo;
    
    public List<Gadget> getAll() {
        return repo.getAll();
    }
    
    public Optional<Gadget> getById(int id) {
        return repo.getById(id);
    }
    
    public Gadget save(Gadget gadget) {
        return repo.save(gadget);
    }
    
    public void delete(int id) {
        Optional<Gadget> gadget = repo.getById(id);
        if (gadget.isPresent()) {
            repo.delete(gadget.get());
        }
    }
    
    public Gadget update(Gadget gadget) {
        if (gadget.getId() != null) {
            Optional<Gadget> g = repo.getById(gadget.getId());
            if (g.isPresent()) {
                if (gadget.getBrand() != null) {
                    g.get().setBrand(gadget.getBrand());
                }
                if (gadget.getCategory() != null) {
                    g.get().setCategory(gadget.getCategory());
                }
                if (gadget.getName() != null) {
                    g.get().setName(gadget.getName());
                }
                if (gadget.getDescription() != null) {
                    g.get().setDescription(gadget.getDescription());
                }
                if (gadget.getPrice() != null) {
                    g.get().setPrice(gadget.getPrice());
                }
                if (gadget.getAvailability() != null) {
                    g.get().setAvailability(gadget.getAvailability());
                }
                if (gadget.getQuantity() != null) {
                    g.get().setQuantity(gadget.getQuantity());
                }
                if (gadget.getPhotography() != null) {
                    g.get().setPhotography(gadget.getPhotography());
                }
                return repo.save(g.get());
            }
        }
        return gadget;
    }
}
