package rtjava.projects.ordersystembackend.service;

import rtjava.projects.ordersystembackend.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(Long userId, UserDto updatedUserDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    void deleteUser(Long userId);
}
