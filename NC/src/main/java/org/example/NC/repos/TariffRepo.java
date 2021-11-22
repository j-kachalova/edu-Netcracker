package org.example.NC.repos;

import org.example.NC.domain.Tariff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffRepo extends CrudRepository<Tariff, Long> {
    List<Tariff> findByName(String name);
}
