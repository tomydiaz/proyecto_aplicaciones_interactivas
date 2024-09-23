package com.uade.grupo5.api_trabajo_practico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.grupo5.api_trabajo_practico.repositories.UserRepository;
import com.uade.grupo5.api_trabajo_practico.repositories.entities.User;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) throws Exception {
        return userRepository.getReferenceById(id);

    }

    public User updateUser(
                User user) throws Exception{
            return userRepository.save(user);
    }

    public void deleteUser(Long id) throws Exception{
            userRepository.deleteById(id);
    }    

}
