package io.ravi.repository;

import io.ravi.domain.Username;
import org.springframework.data.repository.CrudRepository;

public interface UsernameRepository extends CrudRepository<Username, Integer> {
    Username findOneByName(String name);
}
