package br.com.teste.springwithjwt.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 45)
    private String login;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 15)
    private String addressCep;

    @Column(nullable = false, length = 10)
    private String addressStreet;

    @Column(nullable = false, length = 10)
    private Integer addressNumber;

    private String addressComplement;

    @Column(nullable = false, length = 50)
    private String addressNeighborhood;

    @Column(nullable = false, length = 50)
    private String addressCity;

    @Column(nullable = false, length = 2)
    private String addressUf;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();


    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddressCep() {
        return addressCep;
    }

    public void setAddress_cep(String address_cep) {
        this.addressCep = address_cep;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public Integer getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Integer addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public String getAddressNeighborhood() {
        return addressNeighborhood;
    }

    public void setAddressNeighborhood(String addressNeighborhood) {
        this.addressNeighborhood = addressNeighborhood;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressUf() {
        return addressUf;
    }

    public void setAddressUf(String addressUf) {
        this.addressUf = addressUf;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setAddressCep(String addressCep) {
        this.addressCep = addressCep;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        this.roles.add(role);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && getLogin().equals(user.getLogin()) && getPassword().equals(user.getPassword()) && getName().equals(user.getName()) && getCpf().equals(user.getCpf()) && getEmail().equals(user.getEmail()) && getAddressCep().equals(user.getAddressCep()) && getAddressStreet().equals(user.getAddressStreet()) && getAddressNumber().equals(user.getAddressNumber()) && getAddressComplement().equals(user.getAddressComplement()) && getAddressNeighborhood().equals(user.getAddressNeighborhood()) && getAddressCity().equals(user.getAddressCity()) && getAddressUf().equals(user.getAddressUf()) && getRoles().equals(user.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getName(), getCpf(), getEmail(), getAddressCep(), getAddressStreet(), getAddressNumber(), getAddressComplement(), getAddressNeighborhood(), getAddressCity(), getAddressUf(), getRoles());
    }
}
