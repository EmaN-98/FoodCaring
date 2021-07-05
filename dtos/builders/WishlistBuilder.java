package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.WishlistDTO;
import ro.tuc.ds2020.dtos.WishlistDetailsDTO;
import ro.tuc.ds2020.entities.Wishlist;

public class WishlistBuilder {

    private WishlistBuilder() {
    }

    public static WishlistDTO toWishlistDTO(Wishlist m) {
        return new WishlistDTO(m.getId(), m.getProducts());
    }

    public static WishlistDetailsDTO toWishlistDetailsDTO(Wishlist m) {
        return new WishlistDetailsDTO(m.getId(), m.getProducts(), m.getDeprivedPersons());
    }

    public static Wishlist toEntity(WishlistDetailsDTO m) {
        return new Wishlist(m.getProducts(),
        		m.getDeprivedPersons());
    }
}
