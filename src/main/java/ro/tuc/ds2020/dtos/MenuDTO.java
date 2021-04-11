package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Restaurant;

import java.util.Objects;
import java.util.UUID;

public class MenuDTO extends RepresentationModel<MenuDTO> {
    private UUID id;
    private Restaurant restaurant;

    public MenuDTO() {
    }

   
	public MenuDTO(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	public MenuDTO(UUID id, Restaurant restaurant) {
		this.id = id;
		this.restaurant = restaurant;
	}



	public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

  
	public Restaurant getRestaurant() {
		return restaurant;
	}



	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}



	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDTO menuDTO = (MenuDTO) o;
        return (restaurant == menuDTO.restaurant) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurant);
    }
}
