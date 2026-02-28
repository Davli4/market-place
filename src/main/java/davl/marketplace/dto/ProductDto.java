package davl.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer sellerId;
    private String sellerName;
    private String sellerLastName;
    private Integer categoryId;
    private String categoryName;
}
