package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tuc.ds2020.entities.Wishlist2;

import java.util.UUID;

public interface Wishlist2Repository extends JpaRepository<Wishlist2, UUID> {
}
