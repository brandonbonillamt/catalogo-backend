/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.crud;

import com.example.catalogo.modelo.Gadget;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author DELL - PC
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget, Integer>{
    
    @Query("{ 'price': { $lte: ?0 } }")
    public List<Gadget> findByPrice(Double price);
    
    @Query("{ 'description': { $regex: /?0/, $options: 'i' } }")
    public List<Gadget> findByDescription(String descript);
}
