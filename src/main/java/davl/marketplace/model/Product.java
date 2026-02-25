package davl.marketplace.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private User seller;
    private Category category;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
