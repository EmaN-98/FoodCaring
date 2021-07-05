package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="wishlist_2")
public class Wishlist2 {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "id_deprived")
    private UUID idDeprived;

    @Column(name = "id_product")
    private UUID idProduct;

    public Wishlist2() {
    }

    public Wishlist2(UUID id, UUID idDeprived, UUID idProduct) {
        this.id = id;
        this.idDeprived = idDeprived;
        this.idProduct = idProduct;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdDeprived() {
        return idDeprived;
    }

    public void setIdDeprived(UUID idDeprived) {
        this.idDeprived = idDeprived;
    }

    public UUID getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(UUID idProduct) {
        this.idProduct = idProduct;
    }
}
