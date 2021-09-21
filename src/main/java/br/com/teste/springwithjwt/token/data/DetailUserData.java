package br.com.teste.springwithjwt.token.data;

import br.com.teste.springwithjwt.entity.Role;
import br.com.teste.springwithjwt.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DetailUserData  implements UserDetails {

    private static Logger logger = LoggerFactory.getLogger(DetailUserData.class);

    public final Optional<User> user;

    public DetailUserData(Optional<User> user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = this.user.get().getRoles();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role: roles){
            if (role != null){
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            }
        }

        return authorities;
    }

    @Override
    public String getPassword() {

        return user.get().getPassword();
    }

    @Override
    public String getUsername() {

        return user.get().getLogin();
    }

    public Optional<User> getUser() {
        return user;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
