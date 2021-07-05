package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.entities.Restaurant;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class WishlistDTO extends RepresentationModel<WishlistDTO> {
    private UUID id;
    private List<Product> products;


	
	public WishlistDTO() {

	}
	
	public WishlistDTO(List<Product> products) {
		
		this.products = products;
	}

	public WishlistDTO(UUID id, List<Product> products) {

		this.id = id;
		this.products = products;
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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishlistDTO wishlistDTO = (WishlistDTO) o;
        return (products == wishlistDTO.products) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }
}
