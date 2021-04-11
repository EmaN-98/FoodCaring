package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.MenuDTO;
import ro.tuc.ds2020.dtos.MenuDetailsDTO;
import ro.tuc.ds2020.entities.Menu;

public class MenuBuilder {

    private MenuBuilder() {
    }

    public static MenuDTO toMenuDTO(Menu m) {
        return new MenuDTO(m.getId(), m.getRestaurant());
    }

    public static MenuDetailsDTO toMenuDetailsDTO(Menu m) {
        return new MenuDetailsDTO(m.getId(), m.getRestaurant(), m.getProducts());
    }

    public static Menu toEntity(MenuDetailsDTO m) {
        return new Menu(m.getRestaurant(),
        		 m.getProducts());
    }
}
