/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.catalogo.servicios;

import com.example.catalogo.modelo.Order;
import com.example.catalogo.repositorios.OrderRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL - PC
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;

    public List<Order> getAll() {
        return repo.getAll();
    }

    public Optional<Order> getById(int id) {
        return repo.getById(id);
    }

    public List<Order> getBySalesMan(int idSalesMan) {
        return repo.getBySalesMan(idSalesMan);
    }

    public List<Order> getByStatusAndSalesMan(String status, int idSalesMan) {
        return repo.getByStatusAndSalesMan(status, idSalesMan);
    }

    public List<Order> getByDateAndSalesMan(String date, int idSalesMan) {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date stringToDate = new Date();
        try {
            stringToDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return repo.getByDateAndSalesMan(stringToDate, idSalesMan);
    }

    public Order save(Order order) {
        return repo.save(order);
    }

    public void delete(int id) {
        Optional<Order> order = repo.getById(id);
        if (order.isPresent()) {
            repo.delete(order.get());
        }
    }

    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> o = repo.getById(order.getId());
            if (o.isPresent()) {
                if (order.getRegisterDay() != null) {
                    o.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null) {
                    o.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    o.get().setSalesMan(order.getSalesMan());
                }
                if (order.getProducts() != null) {
                    o.get().setProducts(order.getProducts());
                }
                if (order.getQuantities() != null) {
                    o.get().setQuantities(order.getQuantities());
                }
                return repo.save(o.get());
            }
        }
        return order;
    }

    public List<Order> getByZone(String zone) {
        return repo.getByZone(zone);
    }
}
