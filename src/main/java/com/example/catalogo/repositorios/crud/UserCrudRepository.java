/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.repositorios.crud;

import com.example.catalogo.modelo.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author DELL - PC
 */
public interface UserCrudRepository extends MongoRepository<User, Integer>{
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    public Optional<User> findByEmail(String email);
}
