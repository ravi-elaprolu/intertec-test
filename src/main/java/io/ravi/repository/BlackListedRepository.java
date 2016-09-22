package io.ravi.repository;

import io.ravi.domain.Blacklisted;
import org.springframework.data.repository.CrudRepository;

public interface BlackListedRepository extends CrudRepository<Blacklisted, Integer> {

    String findByName(String name);
}
