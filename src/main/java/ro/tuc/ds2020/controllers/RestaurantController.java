package ro.tuc.ds2020.controllers;


import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.minidev.json.JSONObject;
import ro.tuc.ds2020.dtos.RestaurantDetailsDTO;
import ro.tuc.ds2020.services.RestaurantService;
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


	    @GetMapping("/getRestaurants")
	    public ResponseEntity<?> getRestaurants() {
	        try {
		  	      return ResponseEntity.ok().body(restaurantService.findRestaurants());
		  	    } catch (ServiceException e) {
		  	      return ResponseEntity.badRequest().body(e.getMessage());
		  	    }
	    }
	    
	   
	    @GetMapping(value = "/getRestaurant/{id}")
	    public ResponseEntity<?> getRestaurant(@PathVariable("id") UUID restaurantId) {
	        try {
		  	      return ResponseEntity.ok().body(restaurantService.findRestaurantById(restaurantId));
		  	    } catch (ServiceException e) {
		  	      return ResponseEntity.badRequest().body(e.getMessage());
		  	    }
	    }
	    
	    @GetMapping(value = "/getRestaurantByName/{name}")
	    public ResponseEntity<?> getRestaurantByName(@PathVariable("name") String name) {
	        try {
		  	      return ResponseEntity.ok().body(restaurantService.findRestaurantByName(name));
		  	    } catch (ServiceException e) {
		  	      return ResponseEntity.badRequest().body(e.getMessage());
		  	    }
	    }
	    
	    
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
	    
	    
	    @DeleteMapping(value = "/deleteRestaurant")
	    public ResponseEntity<?> deleteRestaurant(@RequestBody RestaurantDetailsDTO restaurantDTO){
	    	JSONObject res = new JSONObject();
			res.put("message", restaurantService.deleteById(restaurantDTO.getId()));
	    	 try {
		  	      return ResponseEntity.ok().body(res);
		  	    } catch (ServiceException e) {
		  	      return ResponseEntity.badRequest().body(e.getMessage());
		  	    }
	    }
	    

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
	    
}
