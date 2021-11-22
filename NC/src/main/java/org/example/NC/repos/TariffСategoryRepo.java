package org.example.NC.repos;

import org.example.NC.domain.TariffСategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TariffСategoryRepo extends CrudRepository<TariffСategory, Long> {
        List<TariffСategory> findByTag(String tag);
}
