package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.DeprivedPerson;
import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.entities.Restaurant;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class WishlistDetailsDTO extends RepresentationModel<WishlistDetailsDTO> {
    private UUID id;
    private List<Product> products;
    private List<DeprivedPerson> deprivedPersons;

	
	public WishlistDetailsDTO() {

	}
	
	

	public WishlistDetailsDTO(List<Product> products, List<DeprivedPerson> deprivedPersons) {
		super();
		this.products = products;
		this.deprivedPersons = deprivedPersons;
	}



	public WishlistDetailsDTO(UUID id, List<Product> products, List<DeprivedPerson> deprivedPersons) {
		super();
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



	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishlistDetailsDTO wishlistDTO = (WishlistDetailsDTO) o;
        return (products == wishlistDTO.products &&
        		Objects.equals(deprivedPersons,wishlistDTO.deprivedPersons)) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(products,deprivedPersons);
    }
}
