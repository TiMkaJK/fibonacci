package com.pristavka.fibonacci.repository;

import com.pristavka.fibonacci.entity.Statistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsRepository extends CrudRepository<Statistics, Long> {

    Optional<Statistics> findByRequestValue(@Param("requestValue") Integer requestValue);
}

