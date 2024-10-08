package com.lulski.blog.sage.user;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.lulski.blog.sage.util.Constant.API_PATH;
import static com.lulski.blog.sage.util.Constant.PATH_USER;


//https://www.javaguides.net/2019/08/spring-boot-spring-data-jpa-postgresql-example.html
//tutorial

@RestController
@RequestMapping(API_PATH)
public class UserController {

  @Autowired
  private UserRepository userRepository;


  @Operation(summary = "Return all User entities")
  @GetMapping("/users")
  public ResponseEntity<List<User>> getAllUsers() {

    return ResponseEntity.of(Optional.of(userRepository.findAll()));
  }

  @Operation(summary = "Get user with Id")
  @GetMapping("/user/{id}")
  public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
    Optional<User> optionalUser = userRepository.findById(id);

    return ResponseEntity.of(optionalUser);
  }

  @PostMapping("/user")
  public User createUser(@Valid @RequestBody User user) {
    return userRepository.save(user);
  }

  @PutMapping("/user/{id}")
  public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) throws UserNotFoundException {
    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with ID: " + userId + " doesn't exist"));

    user.setEmail(userDetails.getEmail());
    user.setFirstName(userDetails.getFirstName());
    user.setLastName(userDetails.getLastName());

    final User updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping(PATH_USER + "/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") long userId) throws UserNotFoundException {
    //Optional<User>  user  = userRepository.findById(userId);
    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with ID: " + userId + " doesn't exist"));

//       user.ifPresent(u -> System.out.println(u.toString()) );
//       user.

    userRepository.delete(user);


    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }

}
