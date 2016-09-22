package io.ravi.services;

import io.ravi.repository.BlackListedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlackListedServiceImpl implements BlackListedService {
    @Autowired
    BlackListedRepository blackListedRepository;

    public Boolean checkIfExists(String name) {
        return blackListedRepository.findByName(name)!=null;
    }
}
