package by.divergenny.traveler.mapper;

import by.divergenny.traveler.domain.User;
import by.divergenny.traveler.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User entity);

    User toEntity(UserDto dto);
}
