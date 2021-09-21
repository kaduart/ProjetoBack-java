package br.com.teste.springwithjwt.repository;

import br.com.teste.springwithjwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByLogin(String login);

    Boolean existsUsersByName(String name);
}
