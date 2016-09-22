package io.ravi.services;

import io.ravi.domain.Username;

import java.util.List;

public interface UsernameService {

    Result<Boolean, List<String>> checkUsernameAndSave(String name);

    List<Username> findAll();
}
