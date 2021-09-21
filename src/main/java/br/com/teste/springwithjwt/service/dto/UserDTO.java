package br.com.teste.springwithjwt.service.dto;


import br.com.teste.springwithjwt.entity.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

    private String addressCep;
    private String addressCity;
    private String addressComplement;
    private String addressNeighborhood;
    private Integer addressNumber;
    private String addressStreet;
    private String addressUf;
    private String cpf;
    private String email;
    private String login;
    private String name;
    private String password;
    private boolean enabled;

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Set<Role> roles = new HashSet<>();
    public void addRole(Role role){
        this.roles.add(role);
    }


    public UserDTO() {

    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
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

    public void setAddressCep(String addressCep) {
        this.addressCep = addressCep;
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

}