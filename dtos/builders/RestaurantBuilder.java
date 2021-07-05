package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.RestaurantDTO;
import ro.tuc.ds2020.dtos.RestaurantDetailsDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.entities.Restaurant;
import ro.tuc.ds2020.entities.User;

public class RestaurantBuilder {

    private RestaurantBuilder() {
    }

    public static RestaurantDTO toRestaurantDTO(Restaurant rest) {
        return new RestaurantDTO(rest.getId(), rest.getName(), rest.getAddress());
    }

    public static RestaurantDetailsDTO toRestaurantDetailsDTO(Restaurant rest) {
        return new RestaurantDetailsDTO(rest.getId(), rest.getName(), rest.getAddress(), rest.getRepresentative(), rest.getMenu());
    }

    public static Restaurant toEntity(RestaurantDetailsDTO restDetailsDTO) {
        return new Restaurant(restDetailsDTO.getName(),
        		restDetailsDTO.getAddress(),
        		restDetailsDTO.getRepresentative(),
        		restDetailsDTO.getMenu());
    }
}
