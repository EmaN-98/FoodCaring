package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.entities.Restaurant;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class MenuDetailsDTO extends RepresentationModel<MenuDetailsDTO> {
    private UUID id;
	private UUID id_restaurant;
	private UUID id_product;

 

	public MenuDetailsDTO() {

	}

	public MenuDetailsDTO(UUID id, UUID id_restaurant, UUID id_product) {
		this.id = id;
		this.id_product = id_product;
		this.id_restaurant = id_restaurant;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId_restaurant() {
		return id_restaurant;
	}

	public void setId_restaurant(UUID id_restaurant) {
		this.id_restaurant = id_restaurant;
	}

	public UUID getId_product() {
		return id_product;
	}

	public void setId_product(UUID id_product) {
		this.id_product = id_product;
	}
}
