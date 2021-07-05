package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.entities.User;

public class UserBuilder {

    private UserBuilder() {
    }

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getRole());
    }

    public static UserDetailsDTO toUserDetailsDTO(User user) {
        return new UserDetailsDTO(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getName(), user.getRole());
    }

    public static User toEntity(UserDetailsDTO userDetailsDTO) {
        return new User(userDetailsDTO.getUsername(),
        		userDetailsDTO.getPassword(),
        		userDetailsDTO.getEmail(),
        		userDetailsDTO.getName(),
        		userDetailsDTO.getRole());
    }
}
