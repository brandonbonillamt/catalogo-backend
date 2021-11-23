/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.CatalogoProductos.web;

import com.example.CatalogoProductos.modelo.User;
import com.example.CatalogoProductos.servicios.UserService;
import java.util.List;
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
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserService service;
    
    @GetMapping("/all")
    public List<User> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{email}")
    public boolean checkEmail(@PathVariable("email") String email) {
        return service.checkEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public User getByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.getByEmailAndPassword(email, password);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return service.update(user);
    }
}
