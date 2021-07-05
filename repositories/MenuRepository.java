package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.entities.DeprivedPerson;
import ro.tuc.ds2020.entities.Menu;
import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.entities.Restaurant;
import ro.tuc.ds2020.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<Menu, UUID> {

    /**
     * Example: JPA generate Query by Field
     */


    /**
     * Example: Write Custom Query
     */

}
