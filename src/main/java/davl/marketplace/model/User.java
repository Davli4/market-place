package davl.marketplace.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class User {
    private Integer id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private String phone;
    private Role role;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private List<Order> orders;
    private List<Product> products;
}
