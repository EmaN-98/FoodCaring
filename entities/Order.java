package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="orders")
public class Order {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "id_restaurant")
    private UUID idRestaurant;

    @Column(name = "id_deprived")
    private UUID idDeprived;

    @Column(name = "products")
    private String products;

    @Column(name = "price")
    private Float price;

    public Order(){
    }

    public Order(UUID id, UUID idRestaurant, UUID idDeprived, String products, Float price) {
        this.id = id;
        this.idRestaurant = idRestaurant;
        this.idDeprived = idDeprived;
        this.products = products;
        this.price = price;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(UUID idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public UUID getIdDeprived() {
        return idDeprived;
    }

    public void setIdDeprived(UUID idDeprived) {
        this.idDeprived = idDeprived;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
