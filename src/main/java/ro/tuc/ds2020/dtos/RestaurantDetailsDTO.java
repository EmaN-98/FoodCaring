package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Menu;
import ro.tuc.ds2020.entities.User;

import java.util.Objects;
import java.util.UUID;

public class RestaurantDetailsDTO extends RepresentationModel<RestaurantDetailsDTO> {
    private UUID id;
    private String name;
    private String address;
    private User representative;
    private Menu menu;
    
    public RestaurantDetailsDTO() {
    }
    


	public RestaurantDetailsDTO(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}



	public RestaurantDetailsDTO(String name, String address, User representative,Menu menu) {
		super();
		this.name = name;
		this.address = address;
		this.representative = representative;
	}



	public RestaurantDetailsDTO(UUID id, String name, String address, User representative,Menu menu) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.representative = representative;
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



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public User getRepresentative() {
		return representative;
	}



	public void setRepresentative(User representative) {
		this.representative = representative;
	}



	public Menu getMenu() {
		return menu;
	}



	public void setMenu(Menu menu) {
		this.menu = menu;
	}



	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantDetailsDTO restaurantDTO = (RestaurantDetailsDTO) o;
        return name ==restaurantDTO.name &&
                Objects.equals(address, restaurantDTO.address) &&
                Objects.equals(representative, restaurantDTO.representative) &&
                Objects.equals(menu, restaurantDTO.menu) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,address,representative,menu);
    }
}
