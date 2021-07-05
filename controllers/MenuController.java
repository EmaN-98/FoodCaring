package ro.tuc.ds2020.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.entities.Menu;
import ro.tuc.ds2020.entities.Offer;
import ro.tuc.ds2020.entities.Product;
import ro.tuc.ds2020.repositories.MenuRepository;
import ro.tuc.ds2020.repositories.ProductRepository;
import ro.tuc.ds2020.services.MenuService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/menu")
public class MenuController {

	private final MenuService menuService;
	private final MenuRepository menuRepository;
	private final ProductRepository productRepository;

	@Autowired
	public MenuController(MenuService menuService, MenuRepository m, ProductRepository p) {
		this.menuService = menuService;
		this.menuRepository = m;
		this.productRepository = p;
	}

	@CrossOrigin
	@PostMapping(value="/insertMenu")
	public ResponseEntity<UUID> insertUser(@RequestBody Menu menu) {
		UUID menuID = menuService.insert(menu);
		return new ResponseEntity<>(menuID, HttpStatus.CREATED);
	}

	@CrossOrigin
	@GetMapping(value = "/getMenu/{idRestaurant}")
	public ResponseEntity<List<Product>> getOfferById(@PathVariable UUID idRestaurant) {
		List<Menu> foundMenu = menuRepository.findAll();
		List<Product> fin  = new ArrayList<>();
		for(Menu m : foundMenu){
			if (m.getId_restaurant().equals(idRestaurant)){
				Product pp = productRepository.findById(m.getId_product()).get();
				fin.add(pp);
			}
		}
		return new ResponseEntity<>(fin, HttpStatus.OK);
	}
}