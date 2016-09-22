package io.ravi.services;

import io.ravi.domain.Username;
import io.ravi.repository.UsernameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;

@Service
public class UsernameServiceImpl implements UsernameService {
    @Autowired
    UsernameRepository usernameRepository;

    @Autowired
    BlackListedService blackListedService;

    public Result<Boolean, List<String>> checkUsername(String name) {
        Username username = new Username();
        username.setName(name);

        Result<Boolean, List<String>> result = new Result<>();
        try{
            if(!blackListedService.checkIfExists(name)){
                usernameRepository.save(username);
                result.setValue(true);
            }else{
                throw new Exception("Blacklisted!!");
            }

        }catch (Exception e){
            result.setValue(false);
            int count = 0;
            Set<String> candidateSet = new TreeSet<>();
            while(candidateSet.size()<14){
                String newName = name+count;
                count++;
                Username tempName = usernameRepository.findOneByName(newName);
                if(tempName==null){
                    if(!blackListedService.checkIfExists(newName)){
                        candidateSet.add(newName);
                    }
                }
            }
            List<String> candidateNames = new ArrayList<>();
            candidateNames.addAll(candidateSet);
            result.setNames(candidateNames);
        }
        return result;
    }

    @Override
    public List<Username> findAll() {
        return (List<Username>) usernameRepository.findAll();
    }
}
