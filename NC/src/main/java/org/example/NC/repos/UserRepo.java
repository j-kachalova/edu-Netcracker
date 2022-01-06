package org.example.NC.repos;

import org.example.NC.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Client, Long> {
   // Client findByLogin(String login);

    Client findByUsername(String username);
}
