package com.example.mobilebackendmaks.service;

import com.example.mobilebackendmaks.exception.DaoError;
import com.example.mobilebackendmaks.repository.UserRepository;
import com.example.mobilebackendmaks.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUserExceptCurrent(String userId){
      return userRepository.findAllByUserIdIsNotContaining(userId);
    }

    public Optional<User> getUserById(String userId){
        return userRepository.findById(userId);
    }

    public List<User> getUsersByIds(List<String> userIds){
        return userRepository.findAllByUserIdIsContaining(userIds);
    }
    public User create(User user){
        return userRepository.save(user);
    }
    public User update(User user){
        Optional<User> userOptional = userRepository.findById(user.getUserId());

            User userFromOptional = userOptional.get();
            if(user.getRole()==null){
                user.setRole(userFromOptional.getRole());
            }
            if(user.getEmail()==null){
                user.setEmail(userFromOptional.getEmail());
            }
            if(user.getFullName()==null){
                user.setFullName(userFromOptional.getFullName());
            }
            return userRepository.save(user);

    }
    public void delete(String userId){
        userRepository.deleteById(userId);
    }
    public List<User> searchUsersByFullName(String fullName){
        return userRepository.findAllByFullName(fullName);
    }
}
