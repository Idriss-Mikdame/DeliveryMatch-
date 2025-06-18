package ma.enaa.deliverymatchs.Mapper;

import ma.enaa.deliverymatchs.Dto.UserDto;
import ma.enaa.deliverymatchs.Model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
