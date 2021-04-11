package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;


import java.util.Objects;
import java.util.UUID;

public class UserDetailsDTO extends RepresentationModel<UserDetailsDTO> {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String role;
    
    public UserDetailsDTO() {
    }

 

	public UserDetailsDTO(String username, String password, String email, String name, String role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.role = role;
	}



	public UserDetailsDTO(UUID id, String username, String password, String email, String name, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.role = role;
	}

	public UserDetailsDTO(UserDetailsDTO dto) {
		
		this.id = dto.getId();
		this.username = dto.getUsername();
		this.password = dto.getPassword();
		this.role = dto.getRole();
		this.email = dto.getEmail();
		this.name = dto.getName();
		
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



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsDTO userDetailsDTO = (UserDetailsDTO) o;
        return username == userDetailsDTO.username &&
                Objects.equals(password, userDetailsDTO.password) &&
                Objects.equals(name, userDetailsDTO.name) &&
                Objects.equals(email, userDetailsDTO.email) &&
                Objects.equals(role, userDetailsDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username,password,name, email, role);
    }
}
