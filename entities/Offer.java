package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="offer")
public class Offer{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "id_restaurant")
    private UUID id_restaurant;

    @Column(name = "percentage")
    private Float percentage;

    @Column(name = "final_price")
    private Float final_price;

    public Offer(){

    }

    public Offer(UUID id_restaurant, Float percentage, Float final_price) {
        this.id_restaurant = id_restaurant;
        this.percentage = percentage;
        this.final_price = final_price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(UUID id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public Float getFinal_price() {
        return final_price;
    }

    public void setFinal_price(Float final_price) {
        this.final_price = final_price;
    }
}

