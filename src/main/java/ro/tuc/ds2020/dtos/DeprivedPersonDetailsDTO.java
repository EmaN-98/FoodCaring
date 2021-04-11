package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.entities.Wishlist;

import java.util.Objects;
import java.util.UUID;

public class DeprivedPersonDetailsDTO extends RepresentationModel<DeprivedPersonDetailsDTO> {
    private UUID id;
    private User user;
    private String address;
    private int nr_donations;
    private String allergies;
    private Wishlist wishlist;

    public DeprivedPersonDetailsDTO() {
    }

    


	public DeprivedPersonDetailsDTO(String address, int nr_donations, String allergies) {
		super();
		this.address = address;
		this.nr_donations = nr_donations;
		this.allergies = allergies;
	}




	public DeprivedPersonDetailsDTO(UUID id, String address, int nr_donations, String allergies, Wishlist wishlist) {
		super();
		this.id = id;
		this.address = address;
		this.nr_donations = nr_donations;
		this.allergies = allergies;
		this.wishlist = wishlist;
	}




	public DeprivedPersonDetailsDTO(User user, String address, int nr_donations, String allergies, Wishlist wishlist) {
		super();
		this.user = user;
		this.address = address;
		this.nr_donations = nr_donations;
		this.allergies = allergies;
		this.wishlist = wishlist;
	}




	public DeprivedPersonDetailsDTO(UUID id, User user, String address, int nr_donations, String allergies,
			Wishlist wishlist) {
		super();
		this.id = id;
		this.user = user;
		this.address = address;
		this.nr_donations = nr_donations;
		this.allergies = allergies;
		this.wishlist = wishlist;
	}




	public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

  

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getNr_donations() {
		return nr_donations;
	}



	public void setNr_donations(int nr_donations) {
		this.nr_donations = nr_donations;
	}



	public String getAllergies() {
		return allergies;
	}



	public void setAllergies(String allergies) {
		this.allergies = allergies;
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
        DeprivedPersonDetailsDTO deprivedPersonDetailsDTO = (DeprivedPersonDetailsDTO) o;
        return (user == deprivedPersonDetailsDTO.user &&
        		Objects.equals(address,deprivedPersonDetailsDTO.address) &&
        				Objects.equals(nr_donations,deprivedPersonDetailsDTO.nr_donations) &&
        						Objects.equals(allergies, deprivedPersonDetailsDTO.allergies) &&
        								Objects.equals(wishlist , deprivedPersonDetailsDTO.wishlist)) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user,address,nr_donations,allergies);
    }
}
