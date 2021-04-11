package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="deprived_person")
public class DeprivedPerson implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "nr_donations", nullable = false)
    private int nr_donations;

    @Column(name = "allergies", nullable = false)
    private String allergies;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_whishlist")
    private Wishlist wishlist;
    
    
  @OneToOne
  @JoinColumn(name = "id_user")
  private User user;

  
	public DeprivedPerson() {
	}

	

	public DeprivedPerson(String address, int nr_donations, String allergies) {
	
		this.address = address;
		this.nr_donations = nr_donations;
		this.allergies = allergies;
	}



	public DeprivedPerson(String address, int nr_donations, String allergies, User user) {
	
		this.address = address;
		this.nr_donations = nr_donations;
		this.allergies = allergies;
		this.user = user;
	}



	public DeprivedPerson(UUID id, String address, int nr_donations, String allergies) {
	
		this.id = id;
		this.address = address;
		this.nr_donations = nr_donations;
		this.allergies = allergies;
	}



	public DeprivedPerson(UUID id, User user, String address, int nr_donations, String allergies, Wishlist wishlist) {
	
		this.id = id;
		this.address = address;
		this.nr_donations = nr_donations;
		this.allergies = allergies;
		this.wishlist = wishlist;
		this.user = user;
	}
	
	public DeprivedPerson(User user, String address, int nr_donations, String allergies, Wishlist wishlist) {
	
		this.address = address;
		this.nr_donations = nr_donations;
		this.allergies = allergies;
		this.wishlist = wishlist;
		this.user = user;
	}




	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Wishlist getWishlist() {
		return wishlist;
	}



	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}



	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "DeprivedPerson [id=" + id + ", address=" + address + ", nr_donations=" + nr_donations + ", allergies="
				+ allergies + "]";
	}

   
}
