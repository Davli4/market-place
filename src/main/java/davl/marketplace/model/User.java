package davl.marketplace.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class User {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<Order> orders;
    private List<Product> products;
}
