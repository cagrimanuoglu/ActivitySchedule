package com.example.Activity_Project.mapper;

import com.example.Activity_Project.dto.UserDto;
import com.example.Activity_Project.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "name",target = "name")
    @Mapping(source = "password",target = "password")
    @Mapping(source = "city",target = "city")
    User fromDto(UserDto userDto);

    @InheritInverseConfiguration(name = "fromDto")
    UserDto toDto(User user);


}
