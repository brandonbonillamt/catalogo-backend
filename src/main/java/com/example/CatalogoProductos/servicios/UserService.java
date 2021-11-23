/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CatalogoProductos.servicios;

import com.example.CatalogoProductos.modelo.User;
import com.example.CatalogoProductos.repositorios.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL - PC
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;
    
    public List<User> getAll() {
        return repo.getAll();
    }
    
    public Optional<User> getById(int id) {
        return repo.getById(id);
    }
    
    public boolean checkEmail(String email) {
        Optional<User> user = repo.getByEmail(email);
        if (user.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
    
    public User getByEmailAndPassword(String email, String password) {
        Optional<User> user = repo.getByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            User u = new User();
            u.setEmail(email);
            u.setPassword(password);
            u.setName("NO DEFINIDO");
            return u;
        }
    }
    
    public User save(User user) {
        return repo.save(user);
    }
    
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> u = repo.getById(0);
            if (u.isPresent()) {
                if (user.getEmail() != null) {
                    u.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    u.get().setPassword(user.getPassword());
                }
                if (user.getName() != null) {
                    u.get().setPassword(user.getName());
                }
                return repo.save(u.get());
            }
        }
        return user;
    }
    
    public boolean delete(int id) {
        Boolean b = repo.getById(id).map(user -> {
            repo.delete(user);
            return true;
        }).orElse(false);
        return b;
    }
}
