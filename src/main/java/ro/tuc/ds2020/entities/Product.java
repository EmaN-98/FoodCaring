package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity 
@Table(name="product")
public class Product  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "allergens", nullable = false)
    private String allergens;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu")
    private Menu menu;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_whishlist")
    private Wishlist wishlist;

	public Product() {
	}

	
	public Product(String name, String allergens) {
		super();
		this.name = name;
		this.allergens = allergens;
	}


	public Product(String name, String allergens, Wishlist wishlist) {
		super();
		this.name = name;
		this.allergens = allergens;
		this.wishlist = wishlist;
	}


	public Product(String name, String allergens, Menu menu) {
		super();
		this.name = name;
		this.allergens = allergens;
		this.menu = menu;
	}


	public Product(String name, String allergens, Menu menu, Wishlist wishlist) {
		super();
		this.name = name;
		this.allergens = allergens;
		this.menu = menu;
		this.wishlist = wishlist;
	}


	public Product(UUID id, String name, String allergens, Menu menu, Wishlist wishlist) {
		super();
		this.id = id;
		this.name = name;
		this.allergens = allergens;
		this.menu = menu;
		this.wishlist = wishlist;
	}




	public String getAllergens() {
		return allergens;
	}




	public void setAllergens(String allergens) {
		this.allergens = allergens;
	}




	public Wishlist getWishlist() {
		return wishlist;
	}




	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}




	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", allergens=" + allergens + ", menu=" + menu + ", wishlist="
				+ wishlist + "]";
	}


	
	

	

   
}
