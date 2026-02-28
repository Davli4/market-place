package davl.marketplace.mapper;

import davl.marketplace.dto.NewUserRequest;
import davl.marketplace.dto.ProductSummaryDto;
import davl.marketplace.dto.UpdateUserRequest;
import davl.marketplace.dto.UserDto;
import davl.marketplace.model.Product;
import davl.marketplace.model.Role;
import davl.marketplace.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {
    public static User mapToUser(NewUserRequest newUserRequest) {
        User user = new User();
        user.setFirstName(newUserRequest.getFirstName());
        user.setLastName(newUserRequest.getLastName());
        user.setEmail(newUserRequest.getEmail());
        user.setPassword(newUserRequest.getPassword());
        user.setPhone(newUserRequest.getPhone());
        user.setRole(Role.CUSTOMER);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        user.setProducts(Collections.emptyList());
        user.setOrders(Collections.emptyList());
        return user;
    }

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());

        if (user.getRole() != null) {
            userDto.setRole(user.getRole().name());
        } else {
            userDto.setRole(null);
        }

        if (user.getProducts() != null) {
            userDto.setProducts(user.getProducts().stream()
                    .map(UserMapper::mapToProductSummaryDto)
                    .collect(Collectors.toList()));
        }

        return userDto;
    }

    private static ProductSummaryDto mapToProductSummaryDto(Product product) {
        ProductSummaryDto productSummaryDto = new ProductSummaryDto();
        productSummaryDto.setId(product.getId());
        productSummaryDto.setName(product.getName());
        productSummaryDto.setPrice(product.getPrice());
        productSummaryDto.setQuantity(product.getQuantity());

        return  productSummaryDto;
    }

    public static User updateUser(User user, UpdateUserRequest updateUserRequest) {
        if (updateUserRequest.hasFirstName()) {
            user.setFirstName(updateUserRequest.getFirstName());
        }
        if (updateUserRequest.hasLastName()) {
            user.setLastName(updateUserRequest.getLastName());
        }
        if (updateUserRequest.hasPassword()) {
            user.setPassword(updateUserRequest.getPassword());
        }
        if (updateUserRequest.hasEmail()) {
            user.setEmail(updateUserRequest.getEmail());
        }
        if (updateUserRequest.hasPhone()) {
            user.setPhone(updateUserRequest.getPhone());
        }
        if (updateUserRequest.hasProducts()) {
            user.setProducts(new ArrayList<>());
        }
        return  user;
    }
 }
