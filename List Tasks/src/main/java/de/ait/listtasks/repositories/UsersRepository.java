package de.ait.listtasks.repositories;

import de.ait.listtasks.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<User, Long> {
}
