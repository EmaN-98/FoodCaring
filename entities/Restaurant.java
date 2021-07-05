package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity 
@Table(name="restaurant")
public class Restaurant  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rep")
    private User representative;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_menu")
    private Menu menu;

	public Restaurant() {
	}

	public Restaurant(UUID id, String name, String address, User representative,Menu menu) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.representative = representative;
		this.menu = menu;
	}

	public Restaurant(String name, String address, User representative,Menu menu) {
		this.name = name;
		this.address = address;
		this.representative = representative;
		this.menu = menu;
	}

	public Restaurant(String name, String address) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", representative=" + representative
				+ ", menu=" + menu + "]";
	}

	
	

   
}
