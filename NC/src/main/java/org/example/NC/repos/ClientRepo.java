package org.example.NC.repos;

import org.example.NC.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends CrudRepository<Client, Long> {
    List<Client> findByTag(String tag);
}
