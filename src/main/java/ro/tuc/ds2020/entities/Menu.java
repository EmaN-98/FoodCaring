package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity 
@Table(name="menu")
public class Menu  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
    private List<Product> products;

	public Menu() {
	}

	public Menu(UUID id, Restaurant restaurant, List<Product> products) {
		this.id = id;
		this.restaurant = restaurant;
		this.products = products;
	}

	public Menu(Restaurant restaurant, List<Product> products) {
		this.restaurant = restaurant;
		this.products = products;
	}

	public Menu(UUID id, Restaurant restaurant) {
		this.id = id;
		this.restaurant = restaurant;
	}


	public Menu(Restaurant restaurant) {
		super();
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", restaurant=" + restaurant + ", products=" + products + "]";
	}


	

   
}
