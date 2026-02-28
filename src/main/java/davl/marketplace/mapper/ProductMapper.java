package davl.marketplace.mapper;

import davl.marketplace.dto.NewProductRequest;
import davl.marketplace.dto.ProductDto;
import davl.marketplace.model.Product;
import davl.marketplace.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMapper {
    public static Product mapToProduct(NewProductRequest newProductRequest, User seller) {
        Product product = new Product();
        product.setName(newProductRequest.getName());
        product.setDescription(newProductRequest.getDescription());
        product.setPrice(newProductRequest.getPrice());
        product.setQuantity(newProductRequest.getQuantity());
        product.setSeller(seller);
        product.setCreated_at(LocalDateTime.now());
        product.setUpdated_at(LocalDateTime.now());

        return product;
    }

    public static ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());

        if (product.getSeller() != null) {
            productDto.setSellerId(product.getSeller().getId());
            productDto.setSellerName(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());
        }

        if (product.getCategory() != null) {
            productDto.setCategoryId(product.getCategory().getId());
            productDto.setCategoryName(product.getCategory().getName());
        }

        return productDto;
    }
}
