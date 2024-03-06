package com.example.spring2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CrudRepository<Rate,Long> {
}
