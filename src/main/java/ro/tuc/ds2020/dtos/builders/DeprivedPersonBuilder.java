package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.DeprivedPersonDTO;
import ro.tuc.ds2020.dtos.DeprivedPersonDetailsDTO;
import ro.tuc.ds2020.entities.DeprivedPerson;

public class DeprivedPersonBuilder {

    private DeprivedPersonBuilder() {
    }

    public static DeprivedPersonDTO toDeprivedPersonDTO(DeprivedPerson dp) {
        return new DeprivedPersonDTO(dp.getId(), dp.getUser());
    }

    public static DeprivedPersonDetailsDTO toDeprivedPersonDetailsDTO(DeprivedPerson dp) {
        return new DeprivedPersonDetailsDTO(dp.getId(), dp.getUser(), dp.getAddress(), dp.getNr_donations(), dp.getAllergies(), dp.getWishlist());
    }

    public static DeprivedPerson toEntity(DeprivedPersonDetailsDTO dp) {
        return new DeprivedPerson(dp.getUser(),
        		dp.getAddress(),
        		dp.getNr_donations(),
        		dp.getAllergies(),
        		dp.getWishlist());
    }
}
