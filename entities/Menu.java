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

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_restaurant")
//    private Restaurant restaurant;
    
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
//    private List<Product> products;

	public Menu(){

	}

	public Menu(UUID id_product, UUID id_restaurant) {
		this.id_product = id_product;
		this.id_restaurant = id_restaurant;
	}

	@Column(name = "id_product")
	private UUID id_product;

	@Column(name = "id_restaurant")
	private UUID id_restaurant;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getId_product() {
		return id_product;
	}

	public void setId_product(UUID id_product) {
		this.id_product = id_product;
	}

	public UUID getId_restaurant() {
		return id_restaurant;
	}

	public void setId_restaurant(UUID id_restaurant) {
		this.id_restaurant = id_restaurant;
	}
}
