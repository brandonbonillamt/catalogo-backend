/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.repositorios;

import com.example.catalogo.modelo.User;
import com.example.catalogo.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BRANDARG
 */
@Repository
public class UserRepository {
    
    /**
     * Repositorio con los metrodos CRUD
     */
    @Autowired
    private UserCrudRepository crud;
    
    /**
     * Busca todos los usuarios
     * @return List de los usuarios
     */
    public List<User> getAll() {
        return crud.findAll();
    }
    
    /**
     * Busca el usuario con el id especificado
     * @param idUser La id del usuario a buscar
     * @return el usuario buscado
     */
    public Optional<User> getById(int idUser) {
        return crud.findById(idUser);
    }
    
    /**
     * Busca usuarios por su mes de cumpleaños
     * @param month el mes a buscar
     * @return Lista de usuarios con el mes especificado
     */
    public List<User> getByMonthBirthday(String month) {
        return crud.findByMonthBirthtDay(month);
    }
    
    /**
     * Guarda un usuario
     * @param user el usuario a guardar
     * @return el usuario guardado
     */
    public User save(User user) {
        return crud.save(user);
    }
    
    /**
     * Elimina un usuario
     * @param user el usuario a eliminar
     */
    public void delete(User user) {
        crud.delete(user);
    }
    
    /**
     * Busca un usuario por su email y clave
     * @param email el email a buscar
     * @param password la clave a buscar
     * @return El usuario que coincide con los parametros
     */
    public Optional<User> getByEmailAndPassword(String email, String password) {
        return crud.findByEmailAndPassword(email, password);
    }
    
    /**
     * Busca un usuario por su email
     * @param email el email de usuario
     * @return el usuario que coincide con el email
     */
    public Optional<User> getByEmail(String email) {
        return crud.findByEmail(email);
    }
}
