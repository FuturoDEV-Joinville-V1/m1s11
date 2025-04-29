package br.futurodev.joinville.m1s11.mappers;

import br.futurodev.joinville.m1s11.dtos.users.UserRequestDto;
import br.futurodev.joinville.m1s11.dtos.users.UserResponseDto;
import br.futurodev.joinville.m1s11.entities.User;

import java.util.List;

public class UserMapper {

    private UserMapper() {}

    public static UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .status(user.getStatus())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

    public static List<UserResponseDto> toDtos(List<User> users) {
        return users.stream()
                .map(UserMapper::toDto)
                .toList();
    }

    public static User toEntity(User user, UserRequestDto dto) {
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setRole(dto.getRole());
        return user;
    }

}
