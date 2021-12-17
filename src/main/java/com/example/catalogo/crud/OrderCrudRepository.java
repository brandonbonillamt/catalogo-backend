package com.example.catalogo.crud;

import com.example.catalogo.modelo.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface OrderCrudRepository extends MongoRepository<Order, Integer> {

    @Query("{'salesMan.zone': ?0}")
    public List<Order> findByZone(String zone);

    @Query("{'salesMan.id': ?0}")
    public List<Order> findBySalesManId(int idSalesMan);

    @Query("{'status': ?0, 'salesMan.id': ?1}")
    public List<Order> findByStatusAndSalesManId(String status, int idSalesMan);

    public List<Order> findByRegisterDayAndSalesManId(Date date, int idSalesMan);
}
