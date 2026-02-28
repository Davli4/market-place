package davl.marketplace.controller;

import davl.marketplace.dto.NewUserRequest;
import davl.marketplace.dto.UpdateUserRequest;
import davl.marketplace.dto.UserDto;
import davl.marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> findAll() {return userService.findAll();}

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable int id) {return userService.findById(id);}

    @PostMapping
    public UserDto createUser(@RequestBody NewUserRequest newUserRequest) {
        return userService.save(newUserRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUserFirstName(@PathVariable int id, @RequestBody UpdateUserRequest updateUserRequest) {
        return userService.updateUser(id,updateUserRequest);
    }
}
