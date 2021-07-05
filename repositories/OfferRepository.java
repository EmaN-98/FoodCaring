package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tuc.ds2020.entities.Offer;

import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, UUID> {}
