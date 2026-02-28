package davl.marketplace.dto;

import lombok.Data;

import java.util.List;

@Data
public class UpdateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private List<Integer> products;

    public boolean hasFirstName() {
        return firstName != null;
    }
    public boolean hasLastName() {
        return lastName != null;
    }

    public boolean hasEmail() {
        return email != null;
    }

    public boolean hasPassword() {
        return password != null;
    }

    public boolean hasPhone() {
        return phone != null;
    }

    public boolean hasProducts() {
        return products != null;
    }
}
