package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.entities.Restaurant;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class MenuDetailsDTO extends RepresentationModel<MenuDetailsDTO> {
    private UUID id;
    private Restaurant restaurant;
    private List<Product> products;

 

	public MenuDetailsDTO() {

	}

	public MenuDetailsDTO(Restaurant restaurant, List<Product> products) {
	
		this.restaurant = restaurant;
		this.products = products;
	}

	public MenuDetailsDTO(UUID id, Restaurant restaurant) {

		this.id = id;
		this.restaurant = restaurant;
	}

	public MenuDetailsDTO(UUID id, Restaurant restaurant, List<Product> products) {

		this.id = id;
		this.restaurant = restaurant;
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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
        MenuDetailsDTO menuDTO = (MenuDetailsDTO) o;
        return (restaurant == menuDTO.restaurant &&
        		Objects.equals(products, menuDTO.products)) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurant,products);
    }
}
