/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.repositorios;

import com.example.catalogo.modelo.Gadget;
import com.example.catalogo.repositorios.crud.GadgetCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL - PC
 */
@Repository
public class GadgetRepository {

    @Autowired
    private GadgetCrudRepository crud;

    public List<Gadget> getAll() {
        return (List<Gadget>) crud.findAll();
    }

    public Optional<Gadget> getById(int id) {
        return crud.findById(id);
    }

    public Gadget save(Gadget gadget) {
        return crud.save(gadget);
    }

    public void delete(Gadget gadget) {
        crud.delete(gadget);
    }
}
