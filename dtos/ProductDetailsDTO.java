package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Menu;
import ro.tuc.ds2020.entities.Wishlist;

import java.util.Objects;
import java.util.UUID;

public class ProductDetailsDTO extends RepresentationModel<ProductDetailsDTO> {
    private UUID id;
    private String name;
    private String allergens;
    private Menu menu;
    private Wishlist wishlist;
	private String description;
	private String photo;
	private Float price;

    public ProductDetailsDTO() {
    }



	public ProductDetailsDTO(String name, String allergens) {
		super();
		this.name = name;
		this.allergens = allergens;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public ProductDetailsDTO(UUID id, String name, String allergens) {
		super();
		this.id = id;
		this.name = name;
		this.allergens = allergens;
	}




	public ProductDetailsDTO(String name, String allergens, Menu menu, Wishlist wishlist) {
		super();
		this.name = name;
		this.allergens = allergens;
		this.menu = menu;
		this.wishlist = wishlist;
	}




	public ProductDetailsDTO(UUID id, String name, String allergens, Menu menu, Wishlist wishlist) {
		super();
		this.id = id;
		this.name = name;
		this.allergens = allergens;
		this.menu = menu;
		this.wishlist = wishlist;
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


	public String getAllergens() {
		return allergens;
	}


	public void setAllergens(String allergens) {
		this.allergens = allergens;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public Wishlist getWishlist() {
		return wishlist;
	}


	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetailsDTO productDetailsDTO = (ProductDetailsDTO) o;
        return (name == productDetailsDTO.name &&
        		Objects.equals(allergens, productDetailsDTO.allergens) &&
        				Objects.equals(menu, productDetailsDTO.menu) &&
        						Objects.equals(wishlist, productDetailsDTO.wishlist)) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,allergens,menu, wishlist);
    }
}
