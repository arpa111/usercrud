package com.test.studentcrud;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CustomUserService {
    @Autowired
    private CustomUserRepository userRepository;

    public CustomUser createUser(CustomUser user) {
        return userRepository.save(user);
    }

    public Optional<CustomUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public CustomUser updateUser(Long id, CustomUser userDetails) {
        Optional<CustomUser> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            CustomUser user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        } else {
            return createUser(userDetails);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
