/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CatalogoProductos.repositorios;

import com.example.CatalogoProductos.modelo.User;
import com.example.CatalogoProductos.repositorios.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL - PC
 */
@Repository
public class UserRepository {
    
    @Autowired
    UserCrudRepository crud;
    
    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }
    
    public Optional<User> getByEmailAndPassword(String email, String password) {
        return crud.findByEmailAndPassword(email, password);
    }
    
    public Optional<User> getByEmail(String email) {
        return crud.findByEmail(email);
    }
    
    public Optional<User> getById(int id) {
        return crud.findById(id);
    }
    
    public User save(User user) {
        return crud.save(user);
    }
    
    public void delete(User user) {
        crud.delete(user);
    }
}
