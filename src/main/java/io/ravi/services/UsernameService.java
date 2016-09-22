package io.ravi.services;

import io.ravi.domain.Username;

import java.util.List;

public interface UsernameService {

    Result<Boolean, List<String>>  checkUsername(String name);

    List<Username> findAll();
}
