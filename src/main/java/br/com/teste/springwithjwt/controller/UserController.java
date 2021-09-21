package br.com.teste.springwithjwt.controller;

import java.util.List;
import java.util.Optional;

import br.com.teste.springwithjwt.entity.User;
import br.com.teste.springwithjwt.repository.RoleRepository;
import br.com.teste.springwithjwt.repository.UserRepository;
import br.com.teste.springwithjwt.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1")
public class UserController extends Exception {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    private UserService userService;

    public UserController(UserRepository repository, RoleRepository roleRepository, PasswordEncoder encoder, UserService userService) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.userService = userService;
    }

    @RequestMapping("/users")
    public String home(java.security.Principal user) {
        return "Hello " + user.getName();
    }


    @PostMapping(value = "/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        User userSave = userService.createUser(user);

        return new ResponseEntity<>(userSave, HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.findById(id)
                .map(userBase -> {
                   userService.updateUser(user);
                   return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inconsistência na atualização."));
    }

    @GetMapping(value = "/users/list")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<User>> getAll() {
        List<User> getUsers = userService.getAllUsers();
        return new ResponseEntity<>(getUsers, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/users/getUserId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserId(@PathVariable Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));
    }


    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long id) {
        userService.findById(id)
                        .map(user -> {
                            userService.deleteUserById(user.getId());
                            return Void.TYPE;
                        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }

    @PostMapping("/users/validatePassword")
    public ResponseEntity<Boolean> validatePassword(@RequestParam String login,
                                                    @RequestParam String password) {

        Optional<User> optUser = repository.findUserByLogin(login);

        if (!optUser.isPresent()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        User user = optUser.get();
        boolean valid = encoder.matches(password, user.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        return ResponseEntity.status(status).body(valid);
    }
}
