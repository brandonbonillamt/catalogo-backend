/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.repositorios;

import com.example.catalogo.crud.OrderCrudRepository;
import com.example.catalogo.modelo.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL - PC
 */
@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository crud;
    
    public List<Order> getAll() {
        return crud.findAll();
    }
    
    public Optional<Order> getById(int id) {
        return crud.findById(id);
    }
    
    public List<Order> getBySalesMan(int idSalesMan) {
        return crud.findBySalesManId(idSalesMan);
    }
    
    public List<Order> getByStatusAndSalesMan(String status, int idSalesMan) {
        return crud.findByStatusAndSalesManId(status, idSalesMan);
    }
    
    public List<Order> getByDateAndSalesMan(Date date, int idSalesMan) {
        return crud.findByRegisterDayAndSalesManId(date, idSalesMan);
    }
    
    public Order save(Order order) {
        return crud.save(order);
    }
    
    public void delete(Order order) {
        crud.delete(order);
    }
    
    public List<Order> getByZone(String zone) {
        return crud.findByZone(zone);
    }
}
