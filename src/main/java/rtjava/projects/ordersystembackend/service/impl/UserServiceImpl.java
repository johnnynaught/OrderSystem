package rtjava.projects.ordersystembackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rtjava.projects.ordersystembackend.dto.UserDto;
import rtjava.projects.ordersystembackend.entity.User;
import rtjava.projects.ordersystembackend.exception.ResourceNotFoundException;
import rtjava.projects.ordersystembackend.mapper.UserMapper;
import rtjava.projects.ordersystembackend.repository.UserRepository;
import rtjava.projects.ordersystembackend.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Manual constructor-based injection
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert DTO to entity
        User user = UserMapper.mapToUser(userDto);

        // Save to database
        User savedUser = userRepository.save(user);

        // Convert entity back to DTO
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUserDto) {
        // Find the user in the database, throw exception if not found
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        // Update user fields
        user.setUsername(updatedUserDto.getUsername());
        user.setEmail(updatedUserDto.getEmail());
        user.setPassword(updatedUserDto.getPassword());

        // Save updated user to database
        User savedUser = userRepository.save(user);

        // Convert entity back to DTO
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        // Retrieve user from the database, throw exception if not found
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        // Convert entity to DTO
        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        // Retrieve all users from database
        List<User> users = userRepository.findAll();

        // Convert each user to UserDto
        return users.stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long userId) {
        // Retrieve the user, throw exception if not found
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        // Delete the user
        userRepository.delete(user);
    }
}
