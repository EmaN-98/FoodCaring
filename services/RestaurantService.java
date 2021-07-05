package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.RestaurantDetailsDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.dtos.builders.RestaurantBuilder;
import ro.tuc.ds2020.dtos.builders.UserBuilder;
import ro.tuc.ds2020.entities.Restaurant;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.repositories.RestaurantRepository;
import ro.tuc.ds2020.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantService.class);
    private final RestaurantRepository restaurantRepository;
    
    @Autowired
    
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository=restaurantRepository;
       
    }

//    public String findRestaurant(String name) {
//    	Restaurant rest=null;
//    	rest=restaurantRepository.findByName(name);
//    	if(rest!=null) {
//    		return "found";
//    	}
//    	else return "not found";
//    }
 
    public UUID insert(RestaurantDetailsDTO rest) {
    	Restaurant entity=RestaurantBuilder.toEntity(rest);
    	entity =restaurantRepository.save(entity);
        LOGGER.debug("Restaurant with id {} was inserted in db", entity.getId());
        return entity.getId();
    }

    public List<RestaurantDetailsDTO> findRestaurants() {
        List<Restaurant> restList = restaurantRepository.findAll();
       // for(Restaurant r:restList) {
       // }
        return  restList.stream()
                .map(RestaurantBuilder::toRestaurantDetailsDTO)
                .collect(Collectors.toList());
    }
    
    public RestaurantDetailsDTO findRestaurantById(UUID id) {
        Optional<Restaurant> prosumerOptional = restaurantRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Restaurant with id {} was not found in db", id);
            throw new ResourceNotFoundException(Restaurant.class.getSimpleName() + " with id: " + id);
        }
        return RestaurantBuilder.toRestaurantDetailsDTO(prosumerOptional.get());
    }
    
    public RestaurantDetailsDTO findRestaurantByName(String name) {
        Optional<Restaurant> prosumerOptional = Optional.ofNullable(restaurantRepository.findByName(name));
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Restaurant with name {} was not found in db", name);
            throw new ResourceNotFoundException(Restaurant.class.getSimpleName() + " with name: " + name);
        }
        return RestaurantBuilder.toRestaurantDetailsDTO(prosumerOptional.get());
    }
  
    
    public String deleteById(UUID id) {
   	 Optional<Restaurant> prosumerOptional = restaurantRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Restaurant with id {} was not found in db", id);
            //throw new ResourceNotFoundException(Restaurant.class.getSimpleName() + " with id: " + id);
            return "restaurant not found in db";
        }else {
        	restaurantRepository.deleteById(id);
       	 return "deleted";
        }
   }
   
   public String deleteByName(String name) {
	   Restaurant prosumerOptional = restaurantRepository.findByName(name);
       if (prosumerOptional==null) {
           LOGGER.error("Restaurant with name {} was not found in db", name);
           //throw new ResourceNotFoundException(Restaurant.class.getSimpleName() + " with name: " + name);
           return "restaurant not found in db";
       }else {
    	   restaurantRepository.delete(prosumerOptional);
    	   return "deleted";
       }
  }
   
   
   public String update(UUID id,RestaurantDetailsDTO user) {
  	 	Optional<Restaurant> prosumerOptional = restaurantRepository.findById(id);
  	 
       if (!prosumerOptional.isPresent()) {
           LOGGER.error("Restaurant with id {} was not found in db", id);
           //throw new ResourceNotFoundException(Restaurant.class.getSimpleName() + " with id: " + id);
       return "restaurant not found in db";
       }else {
    	   Restaurant c=prosumerOptional.get();
       	c.setName(user.getName());
       	c.setAddress(user.getAddress());
       	c.setRepresentative(user.getRepresentative());
       
       	c=restaurantRepository.save(c);
       	//return RestaurantBuilder.toRestaurantDetailsDTO(c);
       	return "updated";
       }
  }

    public List<Restaurant> getAllProducts() {
        List<Restaurant> list = restaurantRepository.findAll();
        for (Restaurant r: list){
            System.out.println(r);
        }
        return list;
    }

    public List<Restaurant> findRestaurantByRepres(UUID represId) {
        List<Restaurant> list = restaurantRepository.findAll();

        List<Restaurant> returnList = new ArrayList<>();

        for(Restaurant r: list){
            if (r.getRepresentative()!= null){
                if (r.getRepresentative().getId().equals(represId)){
                    returnList.add(r);
                }
            }
        }
        return returnList;
    }
}
