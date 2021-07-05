package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;
import java.util.UUID;

public class UserDTO extends RepresentationModel<UserDTO> {
    private UUID id;
    private String username;
    private String password;
    
    public UserDTO() {
    }

    

    public UserDTO(UUID id,String username,  String password) {
		this.id=id;
		this.username = username;
		this.password = password;
	}



	public UserDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}



	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	


	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return username ==userDTO.username &&
                Objects.equals(password, userDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username,password);
    }
}
