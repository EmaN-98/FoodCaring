package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ro.tuc.ds2020.entities.Restaurant;
import ro.tuc.ds2020.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

    /**
     * Example: JPA generate Query by Field
     */
	Restaurant findByName(String name);

  	///Boolean existsByName(String name);
    /**
     * Example: Write Custom Query
     */
 

}
