package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.entities.DeprivedPerson;
import ro.tuc.ds2020.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeprivedPersonRepository extends JpaRepository<DeprivedPerson, UUID> {

    /**
     * Example: JPA generate Query by Field
     */
	DeprivedPerson findByUser(String user_name);

    /**
     * Example: Write Custom Query
     */

}
