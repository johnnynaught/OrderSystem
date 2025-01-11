package rtjava.projects.ordersystembackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rtjava.projects.ordersystembackend.dto.UserDto;
import rtjava.projects.ordersystembackend.service.UserService;

import java.util.List;

/**
 * A REST controller that handles all user-related HTTP requests.
 * It exposes various endpoints to create, read, update, and delete users.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor-based injection of the UserService.
     * Spring will automatically wire an instance of UserService here
     * as long as there's a bean that implements that interface.
     *
     * @param userService the service that contains all business logic for managing users
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create a new user.
     * Expects a JSON representation of UserDto in the request body.
     * Returns the saved user along with an HTTP 201 (Created) status.
     *
     * @param userDto the user data to be created
     * @return a ResponseEntity containing the created UserDto and 201 status
     */
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * Retrieve a single user by its ID.
     * This endpoint maps to GET /api/users/{id}.
     *
     * @param userId the ID of the user to retrieve
     * @return a ResponseEntity containing the UserDto if found, or an appropriate error if not
     */
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    /**
     * Retrieve a list of all users.
     * Maps to GET /api/users with no path variable.
     *
     * @return a ResponseEntity containing a List of all UserDto objects
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Update an existing user identified by its ID.
     * Expects a JSON representation of UserDto in the request body with updated fields.
     *
     * @param userId          the ID of the user to be updated
     * @param updatedUserDto  the updated user data
     * @return a ResponseEntity containing the updated UserDto
     */
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody UserDto updatedUserDto) {
        UserDto userDto = userService.updateUser(userId, updatedUserDto);
        return ResponseEntity.ok(userDto);
    }

    /**
     * Delete an existing user identified by its ID.
     * Maps to DELETE /api/users/{id}.
     *
     * @param userId the ID of the user to be deleted
     * @return a ResponseEntity with a message confirming the deletion
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("Successfully deleted user " + userId);
    }
}
