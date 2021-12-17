/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.servicios;

import com.example.catalogo.modelo.User;
import com.example.catalogo.repositorios.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BRABDAR
 */
@Service
public class UserService {

    /**
     * Crea un un user repository para funiones CRUD
     */
    @Autowired
    private UserRepository repo;

    /**
     * Llama a los usuarios de la base de datos
     * @return Lista de los usuarios
     */
    public List<User> getAll() {
        return repo.getAll();
    }

    /**
     * Llama a un user por su id
     * @param idUser El id del usuario a buscar
     * @return EL usuario con el id pedido
     */
    public Optional<User> getById(int idUser) {
        return repo.getById(idUser);
    }

    /**
     * Revisa si existe un usuario con un email especifico
     * @param email El email que desea revisar
     * @return true si existe o false si no existe
     */
    public boolean checkEmail(String email) {
        Optional<User> user = repo.getByEmail(email);
        return user.isPresent();
    }

    /**
     * Busca a un usuario con el email y la clave especificados
     * @param email el email del usuario
     * @param password la clave del usuario
     * @return si existe retorna el usuario que coincida
     */
    public User getByEmailAndPassword(String email, String password) {
        Optional<User> user = repo.getByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            return new User();
        }
    }
    
    public List<User> getByMonthBirthday(String month) {
        return repo.getByMonthBirthday(month);
    }

    /**
     * Función CRUD create
     * @param user el usuario a registrar
     * @return el usuario registrado
     */
    public User save(User user) {
        return repo.save(user);
    }

    /**
     * Función CRUD update
     * @param user el usuario con los datos a actualizar
     * @return los datos actualizados
     */
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> iusaa = repo.getById(user.getId());
            if (iusaa.isPresent()) {
                if (user.getIdentification() != null) {
                    iusaa.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    iusaa.get().setName(user.getName());
                }
                if (user.getBirthtDay() != null) {
                    iusaa.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay() != null) {
                    iusaa.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null) {
                    iusaa.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    iusaa.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    iusaa.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    iusaa.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    iusaa.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    iusaa.get().setType(user.getType());
                }
                return repo.save(iusaa.get());
            }
        }
        return user;
    }

    /**
     * Función CRUD delete
     * @param idUser id del usuario a eliminar
     */
    public void delete(int idUser) {
        Optional<User> user = repo.getById(idUser);
        if (user.isPresent()) {
            repo.delete(user.get());
        }
    }
}
