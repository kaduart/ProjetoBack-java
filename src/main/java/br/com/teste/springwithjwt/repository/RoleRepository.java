package br.com.teste.springwithjwt.repository;

import br.com.teste.springwithjwt.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
