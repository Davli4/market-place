package davl.marketplace.dto;

import davl.marketplace.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class NewUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private List<Integer> products;
}
