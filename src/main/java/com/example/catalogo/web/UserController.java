/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.web;

import com.example.catalogo.modelo.User;
import com.example.catalogo.servicios.UserService;
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
@RequestMapping("api/user")
@CrossOrigin
public class UserController {
        
    /**
     * Instancia del servicio del user
     */
    @Autowired
    private UserService service;
    
    /**
     * Endpoint para obtener todos los user
     * @return Lista de todos los User
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return service.getAll();
    }
    
    /**
     * Endpoint para obtener un user especifico
     * @param id El id del user a buscar
     * @return El user buscado
     */
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable("id") int idUser) {
        return service.getById(idUser);
    }
    
    /**
     * Revisa si un email ya existe en la base de datos
     * @param email Email a revisar
     * @return Regresa true si existe o false sino
     */
    @GetMapping("/emailexist/{email}")
    public boolean checkEmail(@PathVariable("email") String email) {
        return service.checkEmail(email);
    }
    
    /**
     * Busca un usuario de acuerda a la combinación correo contraseña
     * @param email Email a buscar
     * @param password Contraseña a buscar
     * @return El usuario buscado, si no existe el nombre es "NO DEFINIDO"
     */
    @GetMapping("/{email}/{password}")
    public User getByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.getByEmailAndPassword(email, password);
    }
    
    /**
     * Endpoint para guardar un nuevo user
     * @param user El user con la información requerida
     * @return El user guardado
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    /**
     * Endpoint para actualizar los datos de un user
     * @param user User con los campos a actualizar
     * @return EL user actualizado
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    /**
     * Endpoint para eliminar un user
     * @param idUser Id del user a eliminar
     * @return True si la eliminación fue exitosa
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idUser) {
        return service.delete(idUser);
    }
}
