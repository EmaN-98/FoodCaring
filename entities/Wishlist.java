package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity 
@Table(name="wishlist")
public class Wishlist  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wishlist")
    private List<Product> products;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wishlist")
    private List<DeprivedPerson> deprivedPersons;

    
	

	public Wishlist() {
	
	}


	public Wishlist(List<Product> products, List<DeprivedPerson> deprivedPersons) {
		
		this.products = products;
		this.deprivedPersons = deprivedPersons;
	}


	public Wishlist(UUID id, List<Product> products, List<DeprivedPerson> deprivedPersons) {
		
		this.id = id;
		this.products = products;
		this.deprivedPersons = deprivedPersons;
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public List<DeprivedPerson> getDeprivedPersons() {
		return deprivedPersons;
	}


	public void setDeprivedPersons(List<DeprivedPerson> deprivedPersons) {
		this.deprivedPersons = deprivedPersons;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Wishlist [id=" + id + ", products=" + products + ", deprivedPersons=" + deprivedPersons + "]";
	}

    
   
}
