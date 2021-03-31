package com.feedback.website.mappers;

import com.feedback.website.dtos.UserDto;
import com.feedback.website.entities.UserEntity;
import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
public interface UserMapper {

    @Mapping(source = "ad", target = "name")
    @Mapping(source = "soyad", target = "surname")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    UserEntity dtoToEntity(UserDto dto);

    @Mapping(source = "name", target = "ad")
    @Mapping(source = "surname", target = "soyad")
    UserDto entityToDto(UserEntity entity);

    List<UserDto> entityListToDtoList(List<UserEntity> entityList);

    List<UserEntity> dtoListtoEntityList(List<UserDto> dtoList);

    //todo maven to gradle
    //todo AOP




}
