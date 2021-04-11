package ro.tuc.ds2020.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.services.MenuService;
import ro.tuc.ds2020.services.WishlistService;
@RestController
@CrossOrigin
@RequestMapping(value = "/wishlist")
public class WishlistController {

	private final WishlistService wishlistService;
	@Autowired
	public WishlistController(WishlistService wishlistService) {
		this.wishlistService = wishlistService;
	}

	
}