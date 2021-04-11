package ro.tuc.ds2020.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.services.MenuService;
@RestController
@CrossOrigin
@RequestMapping(value = "/menu")
public class MenuController {

	private final MenuService menuService;
	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	
}