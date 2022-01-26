package org.example.NC.repos;

import org.example.NC.domain.SIMCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SIMCardRepo extends CrudRepository<SIMCard, Integer> {
}