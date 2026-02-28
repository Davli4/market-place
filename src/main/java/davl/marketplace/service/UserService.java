package davl.marketplace.service;

import davl.marketplace.dal.UserRepository;
import davl.marketplace.dto.NewUserRequest;
import davl.marketplace.dto.UserDto;
import davl.marketplace.exception.NotFoundException;
import davl.marketplace.mapper.UserMapper;
import davl.marketplace.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto findById(Integer id) {
        return userRepository.findById(id)
                .map(UserMapper::mapToUserDto)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    public UserDto save(NewUserRequest newUserRequest) {
        User user = UserMapper.mapToUser(newUserRequest);
        user = userRepository.saveUser(user);
        return  UserMapper.mapToUserDto(user);
    }
}
