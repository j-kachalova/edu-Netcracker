package org.example.NC.repos;

import org.example.NC.domain.NumberSIM;
import org.example.NC.domain.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumberRepo extends JpaRepository<NumberSIM, Integer> {

}

