package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.ProductDTO;
import ro.tuc.ds2020.dtos.ProductDetailsDTO;
import ro.tuc.ds2020.entities.Product;

public class ProductBuilder {

    private ProductBuilder() {
    }

    public static ProductDTO toProductDTO(Product p) {
        return new ProductDTO(p.getId(), p.getName(), p.getAllergens());
    }

    public static ProductDetailsDTO toProductDetailsDTO(Product p) {
        return new ProductDetailsDTO(p.getId(), p.getName(), p.getAllergens(), p.getMenu(), p.getWishlist());
    }

    public static Product toEntity(ProductDetailsDTO p) {
        return new Product(p.getName(),
        		p.getAllergens(),
        		p.getMenu(),
        		p.getWishlist(),
                p.getDescription(),
                p.getPrice(),
                p.getPhoto());
    }
}
