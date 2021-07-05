package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;
import ro.tuc.ds2020.entities.User;

import java.util.UUID;

public class DeprivedFullDTO extends RepresentationModel<DeprivedFullDTO> {

    private UUID id;
    private User user;
    private String address;
    private int nr_donations;
    private String allergies;
    private UUID wishlist;
    private String username;
    private String password;
    private String role;
    private String name;
    private String email;

    public DeprivedFullDTO(){
    }

    public DeprivedFullDTO(UUID id, User user, String address, int nr_donations, String allergies, UUID wishlist, String username, String password, String role, String name, String email) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.nr_donations = nr_donations;
        this.allergies = allergies;
        this.wishlist = wishlist;
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
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

    public UUID getWishlist() {
        return wishlist;
    }

    public void setWishlist(UUID wishlist) {
        this.wishlist = wishlist;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
