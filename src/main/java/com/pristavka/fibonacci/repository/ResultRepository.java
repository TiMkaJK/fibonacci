package com.pristavka.fibonacci.repository;

import com.pristavka.fibonacci.entity.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepository extends CrudRepository<Result, Long> {

    Result findByRequestValue(@Param("requestValue") Integer requestValue);
}

