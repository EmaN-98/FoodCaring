package ro.tuc.ds2020.controllers;


import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.minidev.json.JSONObject;
import ro.tuc.ds2020.dtos.RestaurantDetailsDTO;
import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.entities.Restaurant;
import ro.tuc.ds2020.services.RestaurantService;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;
	
	 @Autowired
	    public RestaurantController(RestaurantService restaurantService) {
	        this.restaurantService = restaurantService;
	    }

	@CrossOrigin
	    @GetMapping("/getRestaurants")
	    public ResponseEntity<List<RestaurantDetailsDTO>> getRestaurants() {
		   return ResponseEntity.ok().body(restaurantService.findRestaurants());

	    }

	@CrossOrigin
	@GetMapping(value = "/getProducts")
	public ResponseEntity<List<Restaurant>> getUserById() {
		List<Restaurant> products = restaurantService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@CrossOrigin
	    @GetMapping(value = "/getRestaurant/{id}")
	    public ResponseEntity<?> getRestaurant(@PathVariable("id") UUID restaurantId) {
	        try {
		  	      return ResponseEntity.ok().body(restaurantService.findRestaurantById(restaurantId));
		  	    } catch (ServiceException e) {
		  	      return ResponseEntity.badRequest().body(e.getMessage());
		  	    }
	    }

	@CrossOrigin
	    @GetMapping(value = "/getRestaurantByName/{name}")
	    public ResponseEntity<?> getRestaurantByName(@PathVariable("name") String name) {
	        try {
		  	      return ResponseEntity.ok().body(restaurantService.findRestaurantByName(name));
		  	    } catch (ServiceException e) {
		  	      return ResponseEntity.badRequest().body(e.getMessage());
		  	    }
	    }

	@CrossOrigin
	    @PostMapping(value="/insertRestaurant")
	    public ResponseEntity<?> insertProsumer(@RequestBody RestaurantDetailsDTO restaurantDTO) {
	        JSONObject res = new JSONObject();
			res.put("message", restaurantService.insert(restaurantDTO));
			try {
		  	      return ResponseEntity.ok().body(res);
		  	    } catch (ServiceException e) {
		  	      return ResponseEntity.badRequest().body(e.getMessage());
		  	    }
	    }

	@CrossOrigin
	    @DeleteMapping(value = "/deleteRestaurant/{id}")
	    public ResponseEntity<?> deleteRestaurant(@PathVariable UUID id){
	    	JSONObject res = new JSONObject();
			res.put("message", restaurantService.deleteById(id));
	    	 try {
		  	      return ResponseEntity.ok().body(res);
		  	    } catch (ServiceException e) {
		  	      return ResponseEntity.badRequest().body(e.getMessage());
		  	    }
	    }

	@CrossOrigin
	    @PutMapping(value = "/updateRestaurant")
	    public ResponseEntity<?> updateRestaurant( @RequestBody RestaurantDetailsDTO restaurantDTO){
	    	JSONObject res = new JSONObject();
			res.put("message", restaurantService.update(restaurantDTO.getId(),restaurantDTO));
	    try {
	  	      return ResponseEntity.ok().body(res);
	  	    } catch (ServiceException e) {
	  	      return ResponseEntity.badRequest().body(e.getMessage());
	  	    }
	    }

	@CrossOrigin
	@GetMapping(value = "/getRestRepres/{id}")
	public ResponseEntity<?> getRestRepres(@PathVariable UUID id) {
		try {
			return ResponseEntity.ok().body(restaurantService.findRestaurantByRepres(id));
		} catch (ServiceException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	    
}
