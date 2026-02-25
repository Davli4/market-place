package davl.marketplace.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    private Integer id;
    private Order order;
    private Product product;
    private Integer quantity;
    private BigDecimal priceAtTime;
}
