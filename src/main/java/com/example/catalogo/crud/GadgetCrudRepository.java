/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.crud;

import com.example.catalogo.modelo.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author DELL - PC
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget, Integer>{
    
}
