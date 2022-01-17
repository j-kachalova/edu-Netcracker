package org.example.NC.repos;

import org.example.NC.domain.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Human, Integer> {
   // Client findByLogin(String login);

    Human findByUsername(String username);
}
