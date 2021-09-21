package br.com.teste.springwithjwt.mapper;

import br.com.teste.springwithjwt.entity.User;
import br.com.teste.springwithjwt.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface UserMapper extends EntityMapper<UserDTO, User> {


    @Mapping(source = "user", target = "user")
    UserDTO toDto(User user);

    @Mapping(source = "user", target = "user")
    User toEntity(UserDTO userDTO);
}
