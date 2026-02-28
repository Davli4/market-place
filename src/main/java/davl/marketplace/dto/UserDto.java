package davl.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import davl.marketplace.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private String firstName;
    private String email;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String phone;
    private String role;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<Integer> productIds;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<ProductSummaryDto> products;
}


