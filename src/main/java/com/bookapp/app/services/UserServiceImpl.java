package com.bookapp.app.services;

import com.bookapp.app.models.User;
import com.bookapp.app.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userRepository.findByUsername(user.getUsername());
    }

    @Override
    public User getUser(Long id) throws Exception {
        User user = userRepository.getOne(id);
        if (user != null) {
            return user;
        } else {
            throw new Exception("User with that id does not exist!");
        }
    }

    @Override
    public User findByUsername(String username)  {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers()  {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        User user = getUser(id);
        if (user != null){
            userRepository.delete(user);
        }
    }
}
