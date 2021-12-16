/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.web;

import com.example.catalogo.modelo.Order;
import com.example.catalogo.servicios.OrderService;
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
@RequestMapping("api/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService service;
    
    @GetMapping("/all")
    public List<Order> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Order> getById(@PathVariable("id") int id) {
        return service.getById(id);
    }
    
    @GetMapping("/zona/{zone}")
    public List<Order> getByZone(@PathVariable("zone") String zone) {
        return service.getByZone(zone);
    }
    
    @GetMapping("/salesman/{id}")
    public List<Order> getBySalesMan(@PathVariable("id") int idSalesMan) {
        return service.getBySalesMan(idSalesMan);
    }
    
    @GetMapping("/date/{fecha}/{id}")
    public List<Order> getByDateAndSalesMan(@PathVariable("fecha") String date, @PathVariable("id") int idSalesMan) {
        return service.getByDateAndSalesMan(date, idSalesMan);
    }
    
    @GetMapping("/state/{status}/{id}")
    public List<Order> getByStatusAndSalesMan(@PathVariable("status") String status, @PathVariable("id") int idSalesMan) {
        return service.getByStatusAndSalesMan(status, idSalesMan);
    }
    
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return service.save(order);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return service.update(order);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }
}
