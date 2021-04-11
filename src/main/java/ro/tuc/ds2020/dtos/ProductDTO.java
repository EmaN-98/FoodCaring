package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;
import java.util.UUID;

public class ProductDTO extends RepresentationModel<ProductDTO> {
    private UUID id;
    private String name;
    private String allergens;

    public ProductDTO() {
    }

    
	public ProductDTO(String name, String allergens) {
		super();
		this.name = name;
		this.allergens = allergens;
	}


	public ProductDTO(UUID id, String name, String allergens) {
		super();
		this.id = id;
		this.name = name;
		this.allergens = allergens;
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


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO productDTO = (ProductDTO) o;
        return (name == productDTO.name &&
        		Objects.equals(allergens, productDTO.allergens)) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,allergens);
    }
}
