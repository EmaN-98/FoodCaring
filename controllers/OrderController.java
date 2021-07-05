package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.entities.Offer;
import ro.tuc.ds2020.entities.Order;
import ro.tuc.ds2020.repositories.MenuRepository;
import ro.tuc.ds2020.repositories.OrderRepository;
import ro.tuc.ds2020.repositories.ProductRepository;
import ro.tuc.ds2020.services.MenuService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/order")
public class OrderController {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderController(OrderRepository r) {
        this.orderRepository = r;
    }

    @CrossOrigin
    @PostMapping(value="/insertOrder")
    public ResponseEntity<UUID> insertOffer(@RequestBody Order order) {
        Order entity = orderRepository.save(order);
        return new ResponseEntity<>(entity.getId(), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(value = "/getOrders/{idUser}")
    public ResponseEntity<List<Order>> getOffers(@PathVariable UUID idUser) {
        List<Order> orders = orderRepository.findAll();
        List<Order> returnList = new ArrayList<>();
        for(Order o: orders){
            if (o.getIdDeprived().equals(idUser)){
                returnList.add(o);
            }
        }
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/deleteOrder/{idOrder}")
    public ResponseEntity<String> deleteOffer(@PathVariable UUID idOrder){
        orderRepository.deleteById(idOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
