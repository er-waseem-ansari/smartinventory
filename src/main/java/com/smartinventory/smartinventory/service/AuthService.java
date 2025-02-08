package com.smartinventory.smartinventory.service;

import com.smartinventory.smartinventory.entity.User;
import com.smartinventory.smartinventory.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    AuthRepository authRepository;
    public boolean createUser(User user){
        User crudResponse = authRepository.save(user);
        if (crudResponse == null){
            return false;
        }
        return true;
    }

    public boolean login(User user){
        List<User> crudResponse = authRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (crudResponse.isEmpty()){
            return false;
        }
        return true;
    }

}
