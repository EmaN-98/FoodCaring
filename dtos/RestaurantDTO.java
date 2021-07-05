package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;
import java.util.UUID;

public class RestaurantDTO extends RepresentationModel<RestaurantDTO> {
    private UUID id;
    private String name;
    private String address;
    
    public RestaurantDTO() {
    }
    


	public RestaurantDTO(String name, String address) {
		this.name = name;
		this.address = address;
	}



	public RestaurantDTO(UUID id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
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



	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantDTO restaurantDTO = (RestaurantDTO) o;
        return name ==restaurantDTO.name &&
                Objects.equals(address, restaurantDTO.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,address);
    }
}
