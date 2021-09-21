package br.com.teste.springwithjwt.service;

import br.com.teste.springwithjwt.entity.Role;
import br.com.teste.springwithjwt.entity.User;
import br.com.teste.springwithjwt.repository.RoleRepository;
import br.com.teste.springwithjwt.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //private UserMapper userMapper;

    private RoleRepository  roleRepository;

    private UserRepository userRepository;

    public UserService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        // this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        Role roleUser = roleRepository.findByRole("User");
        user.addRole(roleUser);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        Role roleUser = roleRepository.findByRole("User");
        user.addRole(roleUser);
        return userRepository.save(user);}

    public List<User> getAllUsers() { return  userRepository.findAll(); }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}


