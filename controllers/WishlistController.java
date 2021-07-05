package ro.tuc.ds2020.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.entities.Order;
import ro.tuc.ds2020.entities.Wishlist2;
import ro.tuc.ds2020.repositories.Wishlist2Repository;
import ro.tuc.ds2020.repositories.WishlistRepository;
import ro.tuc.ds2020.services.MenuService;
import ro.tuc.ds2020.services.WishlistService;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/wishlist")
public class WishlistController {

	private final Wishlist2Repository wishlist2Repository;
	@Autowired
	public WishlistController(Wishlist2Repository wishlist2Repository) {
		this.wishlist2Repository = wishlist2Repository;
	}

	@CrossOrigin
	@PostMapping(value="/insertOrder")
	public ResponseEntity<UUID> insertOffer(@RequestBody Wishlist2 order) {
		Wishlist2 entity = wishlist2Repository.save(order);
		return new ResponseEntity<>(entity.getId(), HttpStatus.CREATED);
	}
}