package br.com.teste.springwithjwt.service;


import br.com.teste.springwithjwt.entity.User;
import br.com.teste.springwithjwt.repository.UserRepository;
import br.com.teste.springwithjwt.token.data.DetailUserData;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Service
public class ImplementationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public ImplementationUserDetailsService( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findUserByLogin(username);

        if (user.equals(null)) {
            throw new UsernameNotFoundException("Usuário [" + username + "]  não foi encontrado");
        }

        return new DetailUserData(user);
    }
}

