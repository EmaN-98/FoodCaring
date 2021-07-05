package ro.tuc.ds2020.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.ProductDetailsDTO;
import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.repositories.ProductRepository;
import ro.tuc.ds2020.services.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/product")
public class ProductController {

	private final ProductService productService;
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@CrossOrigin
	@GetMapping(value = "/getProducts")
	public ResponseEntity<List<Product>> getUserById() {
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping(value = "/deleteProduct/{idProduct}")
	public ResponseEntity<String> deleteProduct(@PathVariable UUID idProduct){
		productService.deleteById(idProduct);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping(value = "/updateProduct")
	public ResponseEntity<String> updateUser(@RequestBody ProductDetailsDTO productDTO){
		productService.updateProduct(productDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value="/insertProduct")
	public ResponseEntity<UUID> insertProduct(@RequestBody ProductDetailsDTO productDTO) {
		UUID userID = productService.insert(productDTO);
		return new ResponseEntity<>(userID, HttpStatus.CREATED);
	}
}