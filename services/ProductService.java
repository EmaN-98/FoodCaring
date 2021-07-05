package ro.tuc.ds2020.services ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.ProductDetailsDTO;
import ro.tuc.ds2020.dtos.builders.ProductBuilder;
import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteById(UUID idProduct) {
        productRepository.deleteById(idProduct);
    }

    public ResponseEntity<Product> updateProduct(ProductDetailsDTO product){
        Product foundProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Product does not exist with id: " + product.getId()));

        foundProduct.setAllergens(product.getAllergens());
        foundProduct.setMenu(product.getMenu());
        foundProduct.setName(product.getName());
        foundProduct.setWishlist(product.getWishlist());
        foundProduct.setDescription(product.getDescription());
        foundProduct.setPrice(product.getPrice());
        foundProduct.setPhoto(product.getPhoto());

        Product updatedProduct = productRepository.save(foundProduct);
        return ResponseEntity.ok(updatedProduct);
    }

    public UUID insert(ProductDetailsDTO productDTO) {
        Product entity= ProductBuilder.toEntity(productDTO);
        entity =productRepository.save(entity);
        return entity.getId();
    }
}
