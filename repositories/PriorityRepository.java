package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tuc.ds2020.entities.Priority;

import java.util.UUID;

public interface PriorityRepository extends JpaRepository<Priority, UUID> {}
