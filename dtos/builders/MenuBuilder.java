package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.MenuDTO;
import ro.tuc.ds2020.dtos.MenuDetailsDTO;
import ro.tuc.ds2020.entities.Menu;

public class MenuBuilder {

    private MenuBuilder() {
    }

    public static MenuDTO toMenuDTO(Menu m) {
        return new MenuDTO(m.getId(), m.getId_restaurant(), m.getId_product());
    }

    public static MenuDetailsDTO toMenuDetailsDTO(Menu m) {
        return new MenuDetailsDTO(m.getId(), m.getId_restaurant(), m.getId_product());
    }

    public static Menu toEntity(MenuDetailsDTO m) {
        return new Menu(m.getId_restaurant(),
        		 m.getId_product());
    }
}
