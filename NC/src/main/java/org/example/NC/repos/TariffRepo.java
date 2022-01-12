package org.example.NC.repos;

import org.example.NC.domain.Tariff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface TariffRepo extends CrudRepository<Tariff, Integer> {
    List<Tariff> findByName(String name);
   // Stream<Tariff> findAllTariff();
}
