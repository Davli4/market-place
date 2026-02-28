package davl.marketplace.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class NewProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private Integer sellerId;
    private Integer categoryId;
}
